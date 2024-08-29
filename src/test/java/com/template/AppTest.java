package com.template;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testCreateAccount() {
        Map<String, Integer> accounts = Map.of();
        Map<String, Integer> updatedAccounts = createAccount(accounts, "mati");
        assertEquals(0, updatedAccounts.get("mati"));
    }

    @Test
    void testCreateExistingAccount() {
        Map<String, Integer> accounts = Map.of("mati", 10);
        Map<String, Integer> updatedAccounts = createAccount(accounts, "mati");
        assertEquals(10, updatedAccounts.get("mati"));
    }

    @Test
    void testDeposit() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = deposit(accounts, "mati", 5);
        assertEquals(15, updatedAccounts.get("mati"));
    }

    @Test
    void testDepositNegative() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        assertThrows(IllegalArgumentException.class, () -> deposit(accounts, "mati", -5));
    }

    @Test
    void testDepositNonExistentAccount() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        assertThrows(IllegalArgumentException.class, () -> deposit(accounts, "unknown", 5));
    }

    @Test
    void testWithdraw() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "mati", 5);
        assertEquals(5, updatedAccounts.get("mati"));
    }

    @Test
    void testWithdrawNegative() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        assertThrows(IllegalArgumentException.class, () -> withdraw(accounts, "mati", -5));
    }

    @Test
    void testWithdrawNonExistentAccount() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        assertThrows(IllegalArgumentException.class, () -> withdraw(accounts, "unknown", 5));
    }

    @Test
    void testWithdrawInsufficientFunds() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        assertThrows(IllegalArgumentException.class, () -> withdraw(accounts, "mati", 15));
    }

    @Test
    void testTransfer() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        Map<String, Integer> updatedAccounts = transfer(accounts, "mati", "jaun", 5);
        assertEquals(5, updatedAccounts.get("mati"));
        assertEquals(25, updatedAccounts.get("jaun"));
    }

    @Test
    void testTransferNegative() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        assertThrows(IllegalArgumentException.class, () -> transfer(accounts, "mati", "jaun", -5));
    }

    @Test
    void testTransferNonExistentAccount() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        assertThrows(IllegalArgumentException.class, () -> transfer(accounts, "mati", "unknown", 5));
    }

    @Test
    void testTransferInsufficientFunds() {
        Map<String, Integer> accounts = Map.of("mati", 10, "jaun", 20);
        assertThrows(IllegalArgumentException.class, () -> transfer(accounts, "mati", "jaun", 15));
    }

    @Test
    void testTransferSameAccount() {
        Map<String, Integer> accounts = Map.of("mati", 10);
        assertThrows(IllegalArgumentException.class, () -> transfer(accounts, "mati", "mati", 5));
    }
}
