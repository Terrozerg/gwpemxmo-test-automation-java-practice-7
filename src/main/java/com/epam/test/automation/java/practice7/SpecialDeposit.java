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
        BigDecimal result = amount;
        int period = this.getPeriod();
        int percent = period;

        for (int i = 0; i < period; i++) {
            BigDecimal addition = result
                    .multiply(BigDecimal.valueOf(percent))
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN);

            result = result.add(addition);

            percent+=period;
        }

        return result.subtract(amount);
    }
}

