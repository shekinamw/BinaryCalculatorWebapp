package com.ontariotechu.sofe3980U;

public class Binary {
    private String number = "0";

    public Binary(String number) {
        if (number == null || number.isEmpty()) {
            this.number = "0";
            return;
        }
        // Validate it's a binary string
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                this.number = "0";
                return;
            }
        }
        this.number = number;
        // Remove leading zeros
        int firstOne = this.number.indexOf('1');
        if (firstOne != -1) {
            this.number = this.number.substring(firstOne);
        } else {
            this.number = "0";
        }
    }

    public String getValue() {
        return this.number;
    }

    public static Binary add(Binary num1, Binary num2) {
        int val1 = Integer.parseInt(num1.number, 2);
        int val2 = Integer.parseInt(num2.number, 2);
        return new Binary(Integer.toBinaryString(val1 + val2));
    }

    public static Binary multiply(Binary num1, Binary num2) {
        int val1 = Integer.parseInt(num1.number, 2);
        int val2 = Integer.parseInt(num2.number, 2);
        return new Binary(Integer.toBinaryString(val1 * val2));
    }

    public static Binary and(Binary num1, Binary num2) {
        int val1 = Integer.parseInt(num1.number, 2);
        int val2 = Integer.parseInt(num2.number, 2);
        return new Binary(Integer.toBinaryString(val1 & val2));
    }

    public static Binary or(Binary num1, Binary num2) {
        int val1 = Integer.parseInt(num1.number, 2);
        int val2 = Integer.parseInt(num2.number, 2);
        return new Binary(Integer.toBinaryString(val1 | val2));
    }
}