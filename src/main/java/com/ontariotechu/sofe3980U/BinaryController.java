package com.ontariotechu.sofe3980U;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * BinaryController - handles web application requests for binary calculator
 */
@Controller
public class BinaryController {

    /**
     * GET request to display the calculator page
     * @param operand1 optional pre-filled operand1
     * @param model Spring model for view
     * @return view name
     */
    @GetMapping("/")
    public String getCalculator(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                                Model model) {
        model.addAttribute("operand1", operand1);
        model.addAttribute("operand1Focused", operand1.isEmpty());
        return "calculator";
    }

    /**
     * POST request to calculate result
     * @param operand1 first binary operand
     * @param operator the operation (+, *, &, |)
     * @param operand2 second binary operand
     * @param model Spring model for view
     * @return view name (result or error)
     */
@PostMapping("/")
public String getResult(@RequestParam(name="operand1", required=false) String operand1,
                        @RequestParam(name="operator", required=false) String operator,
                        @RequestParam(name="operand2", required=false) String operand2,
                        Model model) {
    Binary obj1 = new Binary(operand1);
    Binary obj2 = new Binary(operand2);
    String result = "";
    switch(operator) {
        case "+":
            result = Binary.add(obj1, obj2).getValue();
            break;
        case "*":
            result = Binary.multiply(obj1, obj2).getValue();
            break;
        case "&":
            result = Binary.and(obj1, obj2).getValue();
            break;
        case "|":
            result = Binary.or(obj1, obj2).getValue();
            break;
        default:
            return "error";
    }
	
    model.addAttribute("result", result);
    return "result";
}
}