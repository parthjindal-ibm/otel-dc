package com.vault.exceptions;

public class VaultConfigNotFoundException extends Exception {
    public VaultConfigNotFoundException() {
        super("Vault configuration not found");
    }

    public VaultConfigNotFoundException(String message) {
        super(message);
    }

    public VaultConfigNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VaultConfigNotFoundException(Throwable cause) {
        super(cause);
    }
}


public class VaultException extends Exception {
    public VaultException() {
        super("Could not fetch secrets from vault.");
    }

    public VaultException(String message) {
        super(message);
    }

    public VaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public VaultException(Throwable cause) {
        super(cause);
    }
}


