package com.epam.test.automation.java.practice7;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class SpecialDepositTest {

    @Test
    public void testIncome(){
        Deposit deposit = new SpecialDeposit(BigDecimal.valueOf(1000), 2);
        BigDecimal expected = new BigDecimal("60.80");

        Assert.assertEquals(deposit.income(), expected);
    }
}