package com.template;

import java.util.HashMap;
import java.util.Map;

public class App {

    // Método para crear una cuenta
    public static Map<String, Integer> createAccount(Map<String, Integer> accounts, String account) {
        if (accounts.containsKey(account)) {
            return accounts;
        }
        Map<String, Integer> updatedAccounts = new HashMap<>(accounts);
        updatedAccounts.put(account, 0);
        return updatedAccounts;
    }

    // Método para depositar en una cuenta
    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {
        if (amount <= 0 || !accounts.containsKey(account)) {
            throw new IllegalArgumentException("Invalid deposit.");
        }
        Map<String, Integer> updatedAccounts = new HashMap<>(accounts);
        updatedAccounts.put(account, accounts.get(account) + amount);
        return updatedAccounts;
    }

    // Método para retirar de una cuenta
    public static Map<String, Integer> withdraw(Map<String, Integer> accounts, String account, int amount) {
        if (amount <= 0 || !accounts.containsKey(account) || accounts.get(account) < amount) {
            throw new IllegalArgumentException("Invalid withdrawal.");
        }
        Map<String, Integer> updatedAccounts = new HashMap<>(accounts);
        updatedAccounts.put(account, accounts.get(account) - amount);
        return updatedAccounts;
    }

    // Método para transferir entre cuentas
    public static Map<String, Integer> transfer(Map<String, Integer> accounts, String fromAccount, String toAccount, int amount) {
        if (amount <= 0 || fromAccount.equals(toAccount) || 
            !accounts.containsKey(fromAccount) || !accounts.containsKey(toAccount) ||
            accounts.get(fromAccount) < amount) {
            throw new IllegalArgumentException("Invalid transfer.");
        }
        Map<String, Integer> updatedAccounts = new HashMap<>(accounts);
        updatedAccounts.put(fromAccount, accounts.get(fromAccount) - amount);
        updatedAccounts.put(toAccount, accounts.get(toAccount) + amount);
        return updatedAccounts;
    }
}
