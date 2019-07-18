package com.demo.ss.services;

import com.demo.ss.utils.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;
import java.util.StringTokenizer;

@Stateless
public class AuthServiceImpl implements AuthService {

    @Inject
    private ConfigurationService configurationService;

    private static final String AUTHENTICATION_SCHEME = "Basic";

    public boolean authenticate(final String authCredentials) {

        if (StringUtils.isNullOrEmpty(authCredentials))
            return false;

        if (!authCredentials.trim().startsWith(AUTHENTICATION_SCHEME)) {
            return false;
        }

        final String credentials = authCredentials.substring(AUTHENTICATION_SCHEME.length()).trim();
        final byte[] decoded = DatatypeConverter.parseBase64Binary(credentials);
        final String decodedString = new String(decoded);
        final StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
        if (tokenizer.countTokens() != 2) {
            return false;
        }

        final String userName = tokenizer.nextToken().trim();
        final String password = tokenizer.nextToken().trim();
        final boolean authenticationStatus = configurationService.getConfigurationStringValue(ConfigurationService.USER_NAME).equals(userName)
                && configurationService.getConfigurationStringValue(ConfigurationService.USER_PASS).equals(password);
        return authenticationStatus;
    }
}
