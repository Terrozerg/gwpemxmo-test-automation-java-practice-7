package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */

public class LongDeposit extends Deposit{
    private final static int INCOME_PERCENT = 15;

    public LongDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal amount = new BigDecimal(String.valueOf(this.getAmount()));
        BigDecimal result = amount;
        int period = this.getPeriod();

        for (int i = 6; i < period; i++) {
            BigDecimal addition = result
                    .multiply(BigDecimal.valueOf(INCOME_PERCENT))
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN);

            result = result.add(addition);
        }

        return result.subtract(amount);
    }
}

