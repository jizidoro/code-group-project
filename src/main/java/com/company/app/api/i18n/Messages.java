package com.company.app.api.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Locale;

@Component
@Scope("singleton")
public class Messages {

    private Locale locale;

    @Autowired
    private MessageSource messageSource;

    @PostConstruct
    private void init() {
        this.locale = Locale.getDefault();
    }

    public String get(String code) {
        return this.messageSource.getMessage(code, null, locale);
    }

    public String get(String code, List<Object> args) {
        return this.messageSource.getMessage(code, args.toArray(), locale);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
