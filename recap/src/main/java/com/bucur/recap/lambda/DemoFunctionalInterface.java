package com.bucur.recap.lambda;

public class DemoFunctionalInterface {

    public static void main(String[] args) {
        CosminInterface cosminInterface = new CosminInterface() {
            @Override
            public void writeCode() {
                System.out.println("writing bad code");
            }
        };

        CosminInterface cosminInterface2 = () -> System.out.println("writing bad code");
    }
}
