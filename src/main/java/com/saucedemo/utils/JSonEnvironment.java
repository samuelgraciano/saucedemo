package com.saucedemo.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JSonEnvironment {
    private static final String SETTINGS = "environments/settings.json";
    private static JSonEnvironment environment;
    private final JsonNode jsonObject;

    private JSonEnvironment() {
        try (InputStream input = JSonEnvironment.class.getClassLoader().getResourceAsStream(SETTINGS)) {
            if (input == null) {
                throw new IllegalStateException("No se encontro el recurso " + SETTINGS);
            }
            jsonObject = new ObjectMapper().readTree(input);
            if (jsonObject == null || !jsonObject.isObject()) {
                throw new IllegalStateException(SETTINGS + " debe contener un objeto JSON");
            }
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo leer " + SETTINGS, e);
        }
    }

    public static synchronized JSonEnvironment fromSettings() {
        if (environment == null) {
            environment = new JSonEnvironment();
        }
        return environment;
    }

    public String getValue(String key) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("La clave no puede estar vacia");
        }
        JsonNode value = jsonObject;
        for (String part : key.split("\\.", -1)) {
            if (part.isEmpty() || !value.isObject()) {
                throw new IllegalArgumentException("Clave JSON invalida: " + key);
            }
            value = value.get(part);
            if (value == null) {
                throw new IllegalArgumentException("No se encontro la clave JSON: " + key);
            }
        }
        if (!value.isTextual()) {
            throw new IllegalArgumentException("La clave JSON no contiene texto: " + key);
        }
        return value.textValue();
    }
}
