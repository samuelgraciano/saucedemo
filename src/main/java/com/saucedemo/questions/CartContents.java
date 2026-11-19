package com.saucedemo.questions;

import com.saucedemo.ui.StorePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;

public class CartContents {
    private CartContents() {
    }

    public static Question<Collection<String>> productNames() {
        return Text.ofEach(StorePage.CART_ITEMS);
    }
}
