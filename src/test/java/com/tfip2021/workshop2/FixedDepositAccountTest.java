package com.tfip2021.workshop2;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FixedDepositAccountTest {
    @Test
    public void testSetDuration() {
        FixedDepositAccount fda = new FixedDepositAccount("Chin How", 100);
        boolean oneUpdate = false;
        fda.setDuration(20);
        try {
            fda.setDuration(40);
        }
        catch (IllegalArgumentException e) {
            oneUpdate = true;
        }
        assertTrue("Test failed at allowing multiple updates to duration", oneUpdate);
    }

    @Test
    public void testSetInterest() {
        FixedDepositAccount fda = new FixedDepositAccount("Chin How", 100);
        boolean oneUpdate = false;
        fda.setInterest(20);
        try {
            fda.setInterest(40);
        }
        catch (IllegalArgumentException e) {
            oneUpdate = true;
        }
        assertTrue("Test failed at allowing multiple updates to interest", oneUpdate);
    }
}
