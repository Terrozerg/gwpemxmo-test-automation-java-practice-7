package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */

public class Client {
    private List<Deposit> deposits;

    public Client() {
        this.deposits = new ArrayList<>(10);
    }

    public Client(List<Deposit> deposits){
        if(deposits == null){
            throw new IllegalArgumentException("Cannot create array of null deposits.");
        }
        this.deposits = deposits;
    }

    public void addDeposit(Deposit deposit){
        if(deposit == null){
            throw new IllegalArgumentException("Cannot add null deposit.");
        }
        deposits.add(deposit);
    }

    public BigDecimal totalIncome(){
        return deposits.stream()
                .map(Deposit::income)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal maxIncome(){
        return deposits.stream()
                .map(Deposit::income)
                .max(BigDecimal::compareTo)
                .orElseThrow();
    }

    public BigDecimal getIncomeByNumber(int number){
        try {
            return deposits.get(number - 1).income();
        }catch (IndexOutOfBoundsException e){
            return BigDecimal.ZERO;
        }
    }
}

