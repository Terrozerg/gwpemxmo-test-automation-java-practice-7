package com.epam.test.automation.java.practice7;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class LongDepositTest {
    Deposit deposit;

    @Test
    public void testIncomeBeforeSixMonth(){
        deposit = new LongDeposit(BigDecimal.valueOf(1500), 5);
        BigDecimal expected = new BigDecimal("0.00");

        Assert.assertEquals(deposit.income(), expected);
    }

    @Test
    public void testIncomeAfterSixMonth(){
        deposit = new LongDeposit(BigDecimal.valueOf(2000), 8);
        BigDecimal expected = new BigDecimal("645.00");

        Assert.assertEquals(deposit.income(), expected);
    }
}