package com.vault.auth;

import com.vault.VaultProperties;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

public class AuthFactory {
    private static final Logger logger = Logger.getLogger(AuthFactory.class.getName());

    public static VaultAuthenticationStrategy getVaultAuthStrategyFromConfig(VaultProperties vaultProperties){
        Map<String,Object> authConfig = vaultProperties.getAuthConfig();
        String authType = new ArrayList<>(authConfig.keySet()).get(0);
        return getVaultAuthStrategy(authType, authConfig);
    }
    public static VaultAuthenticationStrategy getVaultAuthStrategy(String authType,Map<String,Object> authConfig){
        logger.info("auth type: "+authType);
        VaultAuthenticationStrategy vaultAuthenticationStrategy = null;
        switch (authType){
            case "token":
                vaultAuthenticationStrategy = new TokenAuthenticationStrategy((String) authConfig.get(authType));
                break;
            case "github":
                vaultAuthenticationStrategy = new GithubAuthenticationStrategy();
                break;
            case "approle":
                vaultAuthenticationStrategy = new AppRoleAuthenticationStrategy();
                break;
            default:

        }
        return vaultAuthenticationStrategy;
    }

}
