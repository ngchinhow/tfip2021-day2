package com.tfip2021.workshop2;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BankAccountTest {
    BankAccount ba = new BankAccount("Chin How", 50);
    @Test
    public void testDeposit() {
        // Test depositing negative value
        try {
            ba.deposit(-100);
        }
        catch (IllegalArgumentException e) {
            assertTrue("Test failed at negative value deposit", true);
        }

        // Test depositing
        ba.deposit(100);
        int transactionSize = ba.getTransactions().size();
        assertTrue(
            "Test failed at transaction not being added to list",
            ba.getTransactions().
                get(transactionSize - 1).
                matches("deposit \\$100\\.0 at <\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{7}>")
        );

        // Test depositing to a closed Account
        ba.closeAccount();
        try {
            ba.deposit(100);
        }
        catch (IllegalArgumentException e) {
            assertTrue("Test failed at depositing to a closed Account", true);
        }
    }

    @Test
    public void testWithdraw() {
        // Test withdrawing a negative value
        try {
            ba.withdraw(-100);
        }
        catch (IllegalArgumentException e) {
            assertTrue("Test failed at negative value withdrawal", true);
        }
        
        // Test withdrawing when there's not enough balance
        try {
            ba.withdraw(100);
        }
        catch (IllegalArgumentException e) {
            assertTrue("Test failed at greater than balance withdrawal", true);
        }
        
        // Test withdrawing
        ba.deposit(100);
        ba.withdraw(100);
        int transactionSize = ba.getTransactions().size();
        assertTrue(
            "Test failed at transaction not being added to list",
            ba.getTransactions().
                get(transactionSize - 1).
                matches("withdraw \\$100\\.0 at <\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{7}>")
        );

        // Test withdrawing from a closed Account
        ba.closeAccount();
        try {
            ba.withdraw(100);
        }
        catch (IllegalArgumentException e) {
            assertTrue("Test failed at withdrawing from a closed Account", true);
        }
    }
}
