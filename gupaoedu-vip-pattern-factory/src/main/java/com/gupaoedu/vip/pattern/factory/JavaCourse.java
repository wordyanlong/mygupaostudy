package com.gupaoedu.vip.pattern.factory;


import java.math.BigDecimal;

/**
 * Created by Tom.
 */
public class JavaCourse implements ICourse {

    public void record() {
        System.out.println("录制Java课程");
    }

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal(7200);
        System.out.println(amount.divide(new BigDecimal(331)).divide(new BigDecimal(2)));
    }
}
