package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */

public abstract class Deposit {
    public final BigDecimal amount;
    public final int period;

    public Deposit(BigDecimal amount, int period){
        this.amount = amount;
        this.period = period;
    }

    public abstract BigDecimal income();

    public BigDecimal incomeBase(BigDecimal amount, int periodStart, int periodEnd, int percent, int increment){
        BigDecimal result = amount;

        for (int i = periodStart; i < periodEnd; i++) {
            BigDecimal addition = result
                    .multiply(BigDecimal.valueOf(percent))
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN);

            result = result.add(addition);

            percent+=increment;
        }

        return result.subtract(amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }
}

