package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */

public class SpecialDeposit extends Deposit{

    public SpecialDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal amount = new BigDecimal(String.valueOf(this.getAmount()));
        int period = this.getPeriod();

        return super.incomeBase(amount, 0, period, 1, 1);
    }
}

