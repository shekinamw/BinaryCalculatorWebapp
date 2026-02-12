package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinaryAPIController {

    @GetMapping("/add")
    public String addString(@RequestParam(name="operand1") String operand1, @RequestParam(name="operand2") String operand2) {
        Binary b1 = new Binary(operand1);
        Binary b2 = new Binary(operand2);
        return Binary.add(b1, b2).getValue();
    }

    @GetMapping("/add_json")
    public BinaryAPIResult addJson(@RequestParam(name="operand1") String operand1, @RequestParam(name="operand2") String operand2) {
        Binary b1 = new Binary(operand1);
        Binary b2 = new Binary(operand2);
        return new BinaryAPIResult(b1, b2, "+", Binary.add(b1, b2));
    }

    @GetMapping("/multiply_json")
    public BinaryAPIResult multiplyJson(@RequestParam(name="operand1") String operand1, @RequestParam(name="operand2") String operand2) {
        Binary b1 = new Binary(operand1);
        Binary b2 = new Binary(operand2);
        return new BinaryAPIResult(b1, b2, "*", Binary.multiply(b1, b2));
    }

    @GetMapping("/and_json")
    public BinaryAPIResult andJson(@RequestParam(name="operand1") String operand1, @RequestParam(name="operand2") String operand2) {
        Binary b1 = new Binary(operand1);
        Binary b2 = new Binary(operand2);
        return new BinaryAPIResult(b1, b2, "&", Binary.and(b1, b2));
    }

    @GetMapping("/or_json")
    public BinaryAPIResult orJson(@RequestParam(name="operand1") String operand1, @RequestParam(name="operand2") String operand2) {
        Binary b1 = new Binary(operand1);
        Binary b2 = new Binary(operand2);
        return new BinaryAPIResult(b1, b2, "|", Binary.or(b1, b2));
    }
}