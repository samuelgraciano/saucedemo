package com.saucedemo.tasks;

import com.saucedemo.ui.StorePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class AddProducts implements Performable {
    public static AddProducts toCart() {
        return Tasks.instrumented(AddProducts.class);
    }

    @Override
    @Step("{0} agrega dos productos al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(StorePage.ADD_BACKPACK),
                Click.on(StorePage.ADD_BIKE_LIGHT)
        );
    }
}
