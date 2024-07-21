package com.company.app.core.bases;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import java.util.Properties;

public class MessageBundle extends ReloadableResourceBundleMessageSource implements Messages {
    private final String basename;

    public MessageBundle(String basename) {
        this.basename = basename;
    }
    
    @Override
    public Properties getMessages() {
        Properties props = this.getProperties(basename + "_"
                + LocaleContextHolder.getLocale()).getProperties();
        if (props == null || props.isEmpty()) {
            props = this.getProperties(basename).getProperties();
        }
        if (props == null || props.isEmpty()) {
            props = this.getMergedProperties(LocaleContextHolder.getLocale())
                    .getProperties();
        }
        return props;
    }

    @Override
    public String getMessage(String code, Object... args) {
        return this.getMessage(code, args, "?" + code + "?", LocaleContextHolder.getLocale());
    }
}
