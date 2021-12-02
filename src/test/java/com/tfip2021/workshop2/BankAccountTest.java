package com.tfip2021.workshop2;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BankAccountTest {
    @Test
    public void testDeposit() {
        BankAccount ba = new BankAccount("Chin How");
        boolean negativeNumber = false;
        boolean alreadyClosed = false;
        try {
            ba.deposit(-100);
        }
        catch (IllegalArgumentException e) {
            negativeNumber = true;
        }
        assertTrue("Test failed at negative value deposit", negativeNumber);

        ba.deposit(100);
        int transactionSize = ba.getTransactions().size();
        assertTrue(
            "Test failed at transaction not being added to list",
            ba.getTransactions().
                get(transactionSize - 1).
                matches("deposit \\$100\\.0 at <\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{7}>")
        );
        ba.closeAccount();
        try {
            ba.deposit(100);
        }
        catch (IllegalArgumentException e) {
            alreadyClosed = true;
        }
        assertTrue("Test failed at depositing to a closed Account", alreadyClosed);
    }

    @Test
    public void testWithdraw() {
        BankAccount ba = new BankAccount("Chin How");
        boolean negativeNumber = false;
        boolean notEnoughBalance = false;
        boolean alreadyClosed = false;
        try {
            ba.withdraw(-100);
        }
        catch (IllegalArgumentException e) {
            negativeNumber = true;
        }
        assertTrue("Test failed at negative value withdrawal", negativeNumber);
        
        try {
            ba.withdraw(100);
        }
        catch (IllegalArgumentException e) {
            notEnoughBalance = true;
        }
        assertTrue("Test failed at greater than balance withdrawal", notEnoughBalance);
        ba.deposit(100);
        ba.withdraw(100);
        int transactionSize = ba.getTransactions().size();
        assertTrue(
            "Test failed at transaction not being added to list",
            ba.getTransactions().
                get(transactionSize - 1).
                matches("withdraw \\$100\\.0 at <\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{7}>")
        );
        ba.closeAccount();
        try {
            ba.withdraw(100);
        }
        catch (IllegalArgumentException e) {
            alreadyClosed = true;
        }
        assertTrue("Test failed at withdrawing from a closed Account", alreadyClosed);
    }
}
