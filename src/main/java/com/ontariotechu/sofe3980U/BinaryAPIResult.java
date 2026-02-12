package com.ontariotechu.sofe3980U;

public class BinaryAPIResult {
    private String operand1;
    private String operator;
    private String operand2;
    private String result;

    public BinaryAPIResult(Binary op1, Binary op2, String operator, Binary result) {
        this.operand1 = op1.getValue();
        this.operand2 = op2.getValue();
        this.operator = operator;
        this.result = result.getValue();
    }

    // Getters are REQUIRED for Spring to build the JSON string
    public String getOperand1() { return operand1; }
    public String getOperator() { return operator; }
    public String getOperand2() { return operand2; }
    public String getResult() { return result; }
}