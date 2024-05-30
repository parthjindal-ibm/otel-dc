package com.vault;

import com.bettercloud.vault.SslConfig;
import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;

import java.io.File;
import java.util.logging.Logger;


public class VaultClient{

    private static final Logger logger = Logger.getLogger(VaultClient.class.getName());

    public static Vault createVaultClient(VaultProperties vaultProperties){
        try{
            final VaultConfig vaultConfig = new VaultConfig()
                    .address(vaultProperties.getConnectionURL());
            if(vaultProperties.getConnectionURL().startsWith("https")){
                SslConfig sslConfig = new SslConfig().pemFile(new File(vaultServiceConfig.getPathToPemFile())).build(); // must be build to verify
                vaultConfig.sslConfig(sslConfig);
                logger.info("Set ssl for Vault");
            }

            VaultAuthenticationStrategy vaultAuthenticationStrategy = AuthFactory.getVaultAuthStrategyFromConfig(vaultProperties);
            vaultConfig.token(vaultAuthenticationStrategy.token().get());
            return new Vault(vaultConfig.build(),vaultServiceConfig.getKvVersion());
        }catch (VaultException e){
            logger.info("An exception occured"+e.getMessage());
        }
        return null;
    }




}