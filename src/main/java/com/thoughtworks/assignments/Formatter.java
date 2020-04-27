package com.thoughtworks.assignments;

import java.text.DecimalFormat;

public class Formatter {

    public static double format(double value) {
        return Double.parseDouble(new DecimalFormat("##.##").format(value));
    }
}
