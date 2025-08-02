// 代码生成时间: 2025-08-02 11:36:56
package com.example.mathtool;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.math.BigDecimal;

/**
 * MathCalculationTool is a utility class that provides a set of mathematical operations.
 * It is designed to be easy to understand, with clear structure, error handling,
 * and proper documentation. It adheres to Java best practices for maintainability
 * and extensibility.
 */
@FacesValidator("mathCalculationValidator")
public class MathCalculationTool implements Validator {

    // Perform addition operation
    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    // Perform subtraction operation
    public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    // Perform multiplication operation
    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    // Perform division operation
    public static BigDecimal divide(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return a.divide(b, MathContext.DECIMAL128);
    }

    // Validate the input values
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mathematical operation cannot be performed on null values.", null));
        }
        try {
            BigDecimal.valueOf((String) value);
        } catch (NumberFormatException e) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid input value for mathematical operation.", null));
        }
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        try {
            BigDecimal result = MathCalculationTool.add(new BigDecimal("10.5"), new BigDecimal("2.3"));
            System.out.println("Addition Result: " + result);

            result = MathCalculationTool.subtract(new BigDecimal("10.5"), new BigDecimal("2.3"));
            System.out.println("Subtraction Result: " + result);

            result = MathCalculationTool.multiply(new BigDecimal("10.5"), new BigDecimal("2.3"));
            System.out.println("Multiplication Result: " + result);

            result = MathCalculationTool.divide(new BigDecimal("10.5"), new BigDecimal("2.3"));
            System.out.println("Division Result: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}