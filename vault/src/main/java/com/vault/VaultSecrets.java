package com.vault;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import com.vault.exceptions;

import com.bettercloud.vault.Vault;

public class VaultSecrets {
    private static final Logger logger = Logger.getLogger(DataCollector.class.getName());

    public static Vault vaultClient;

    public static <T> config getSecretsFromVault(T config){
        if(!config.isVaultPropertyPresent()){
            throw new VaultConfigNotFoundException();
        }
        else{
            logger.info("Vault configuration found.");
            try {
                setVaultClient(config.getVaultProperties());

            }
            catch (VaultException e){
                throw new VaultException(e.getMessage());
            }
        }
        return config;
    }

    private static void setVaultClient(T config){
        vaultClient = VaultClient.createVaultClient(config);
    }
}