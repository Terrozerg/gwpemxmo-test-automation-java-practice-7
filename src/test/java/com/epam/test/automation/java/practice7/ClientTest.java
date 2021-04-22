package com.epam.test.automation.java.practice7;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClientTest {
    private List<Deposit> deposits = new ArrayList<>(List.of(
            new BaseDeposit(BigDecimal.valueOf(1000), 7),
            new BaseDeposit(BigDecimal.valueOf(2000), 3),
            new LongDeposit(BigDecimal.valueOf(1000), 10),
            new SpecialDeposit(BigDecimal.valueOf(500), 5),
            new SpecialDeposit(BigDecimal.valueOf(130), 7)
    ));
    Client client = new Client(deposits);

    @Test(expectedExceptions = IllegalArgumentException.class,
    expectedExceptionsMessageRegExp = "Cannot create array of null deposits.")
    public void testConstructorWithNullDeposits(){
        Client nullClients = new Client(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
    expectedExceptionsMessageRegExp = "Cannot add null deposit.")
    public void testAddNullDeposit(){
        Client addClient = new Client();

        addClient.addDeposit(null);
    }

    @Test
    public void testAddDeposit(){
        Client addClient = new Client();

        Assert.assertTrue(addClient.addDeposit(deposits.get(1)));
    }

    @Test
    public void testAddDepositToFullClient(){
        Client addClient = new Client();
        for (int i = 0; i < 10; i++) {
            addClient.addDeposit(new BaseDeposit(BigDecimal.valueOf(1500), 8));
        }

        Assert.assertFalse(addClient.addDeposit(deposits.get(1)));
    }

    @Test
    public void testGetIncomeByNumber(){
        Assert.assertEquals(client.getIncomeByNumber(4), deposits.get(3).income());
    }

    @Test
    public void testGetIncomeByZeroNumber(){
        Assert.assertEquals(client.getIncomeByNumber(0), BigDecimal.ZERO);
    }

    @Test
    public void testMaxIncome(){
        Assert.assertEquals(client.maxIncome(), deposits.get(2).income());
    }

    @Test
    public void testTotalIncome(){
        BigDecimal total = BigDecimal.ZERO;

        for (Deposit deposit : deposits) {
            total = total.add(deposit.income());
        }

        Assert.assertEquals(client.totalIncome(), total);
    }
}
