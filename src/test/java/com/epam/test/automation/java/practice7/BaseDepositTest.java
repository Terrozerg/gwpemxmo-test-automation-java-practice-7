package com.epam.test.automation.java.practice7;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class BaseDepositTest {

    @Test
    public void testIncome(){
        Deposit deposit = new BaseDeposit(BigDecimal.valueOf(1000), 3);

        Assert.assertEquals(deposit.income(), BigDecimal.valueOf(157.62));
    }
}