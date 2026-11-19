package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target USERNAME = Target.the("usuario").locatedBy("#user-name");
    public static final Target PASSWORD = Target.the("contrasena").locatedBy("#password");
    public static final Target LOGIN_BUTTON = Target.the("boton de inicio de sesion").locatedBy("#login-button");

    private LoginPage() {
    }
}
