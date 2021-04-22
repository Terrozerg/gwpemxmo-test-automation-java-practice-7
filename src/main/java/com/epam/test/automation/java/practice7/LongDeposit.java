package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */

public class LongDeposit extends Deposit{
    private static final int INCOME_PERCENT = 15;

    public LongDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal amount = new BigDecimal(String.valueOf(this.getAmount()));
        int period = this.getPeriod();

        return super.incomeBase(amount, 6, period, INCOME_PERCENT, 0);
    }
}

