package com.amachi.app.film.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
public class Translator {
    public static ResourceBundleMessageSource messageSource;

    public static String toLocale(String code, Object[] args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }

    @PostConstruct
    public void init() {
        messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("errors");
    }
}
