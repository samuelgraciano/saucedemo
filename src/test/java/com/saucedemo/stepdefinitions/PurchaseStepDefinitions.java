package com.saucedemo.stepdefinitions;

import com.saucedemo.models.Customer;
import com.saucedemo.questions.CartContents;
import com.saucedemo.questions.OrderConfirmation;
import com.saucedemo.tasks.AddProducts;
import com.saucedemo.tasks.CompleteCheckout;
import com.saucedemo.tasks.Login;
import com.saucedemo.ui.CheckoutPage;
import com.saucedemo.ui.StorePage;
import com.saucedemo.utils.JSonEnvironment;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class PurchaseStepDefinitions {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que {word} inicia sesion en Sauce Demo")
    public void logIn(String actor) {
        JSonEnvironment settings = JSonEnvironment.fromSettings();
        String username = settings.getValue("usuario");
        String password = settings.getValue("password");
        theActorCalled(actor).wasAbleTo(Login.withCredentials(username, password));
    }

    @When("agrega dos productos al carrito")
    public void addProducts() {
        theActorInTheSpotlight().attemptsTo(AddProducts.toCart());
    }

    @When("visualiza el carrito")
    public void openCart() {
        theActorInTheSpotlight().attemptsTo(Click.on(StorePage.CART));
    }

    @Then("el carrito contiene los productos {string} y {string}")
    public void verifyCart(String firstProduct, String secondProduct) {
        theActorInTheSpotlight().should(
                seeThat(CartContents.productNames(), containsInAnyOrder(firstProduct, secondProduct))
        );
    }

    @When("completa el formulario de compra con nombre {string}, apellido {string} y codigo postal {string}")
    public void completeCheckout(String firstName, String lastName, String postalCode) {
        theActorInTheSpotlight().attemptsTo(
                CompleteCheckout.withData(new Customer(firstName, lastName, postalCode))
        );
    }

    @When("finaliza la compra")
    public void finishPurchase() {
        theActorInTheSpotlight().attemptsTo(Click.on(CheckoutPage.FINISH));
    }

    @Then("el sistema confirma la compra con el mensaje {string}")
    public void confirmPurchase(String message) {
        theActorInTheSpotlight().should(seeThat(OrderConfirmation.message(), equalTo(message)));
    }
}
