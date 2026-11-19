package com.saucedemo.questions;

import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Locale;

public class OrderConfirmation {
    private OrderConfirmation() {
    }

    public static Question<String> message() {
        return actor -> Text.of(CheckoutPage.CONFIRMATION).answeredBy(actor)
                .trim().replaceFirst("!$", "").toUpperCase(Locale.ROOT);
    }
}
