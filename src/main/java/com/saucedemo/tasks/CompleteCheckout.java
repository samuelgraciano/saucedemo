package com.saucedemo.tasks;

import com.saucedemo.models.Customer;
import com.saucedemo.ui.CheckoutPage;
import com.saucedemo.ui.StorePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class CompleteCheckout implements Performable {
    private final Customer customer;

    public CompleteCheckout(Customer customer) {
        this.customer = customer;
    }

    public static CompleteCheckout withData(Customer customer) {
        return Tasks.instrumented(CompleteCheckout.class, customer);
    }

    @Override
    @Step("{0} completa el formulario de compra")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(StorePage.CHECKOUT),
                Enter.theValue(customer.getFirstName()).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(customer.getLastName()).into(CheckoutPage.LAST_NAME),
                Enter.theValue(customer.getPostalCode()).into(CheckoutPage.POSTAL_CODE),
                Click.on(CheckoutPage.CONTINUE)
        );
    }
}
