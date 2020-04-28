package com.thoughtworks.assignments;

import java.text.DecimalFormat;

public class Utility {

    public static double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }

    public static double SALES_TAX_PERCENT = 0.02;
}
