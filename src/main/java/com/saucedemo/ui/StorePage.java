package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class StorePage {
    public static final Target ADD_BACKPACK = Target.the("agregar Sauce Labs Backpack")
            .locatedBy("#add-to-cart-sauce-labs-backpack");
    public static final Target ADD_BIKE_LIGHT = Target.the("agregar Sauce Labs Bike Light")
            .locatedBy("#add-to-cart-sauce-labs-bike-light");
    public static final Target CART = Target.the("carrito de compras").locatedBy(".shopping_cart_link");
    public static final Target CART_ITEMS = Target.the("productos del carrito")
            .locatedBy(".cart_item .inventory_item_name");
    public static final Target CHECKOUT = Target.the("boton de compra").locatedBy("#checkout");

    private StorePage() {
    }
}
