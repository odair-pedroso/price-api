package edu.unifacef.priceapi.utils;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import edu.unifacef.priceapi.exceptions.MessageKey;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageUtils {
	
	private final MessageSource messageSource;
	
	public String getMessage(final MessageKey messageKey, final Object... param) {
		return messageSource.getMessage(messageKey.getKey(), param, getLocale());
		
	}

}
