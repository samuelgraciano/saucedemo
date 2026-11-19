package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {
    public static final Target FIRST_NAME = Target.the("nombre").locatedBy("#first-name");
    public static final Target LAST_NAME = Target.the("apellido").locatedBy("#last-name");
    public static final Target POSTAL_CODE = Target.the("codigo postal").locatedBy("#postal-code");
    public static final Target CONTINUE = Target.the("boton continuar").locatedBy("#continue");
    public static final Target FINISH = Target.the("boton finalizar compra").locatedBy("#finish");
    public static final Target CONFIRMATION = Target.the("mensaje de confirmacion").locatedBy(".complete-header");

    private CheckoutPage() {
    }
}
