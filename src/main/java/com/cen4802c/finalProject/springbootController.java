package com.cen4802c.finalProject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class springbootController {
    private static final Logger logger = LoggerFactory.getLogger(springbootController.class);
    private final JavaCalculator calculator = new JavaCalculator();

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) {
        logger.debug("Received request for addition with parameters: a={}, b={}", a, b);
        double result = calculator.add(a, b);
        logger.info("Addition result: {} + {} = {}", a, b, result);
        return result;
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
        logger.debug("Received request for subtraction with parameters: a={}, b={}", a, b);
        double result = calculator.subtract(a, b);
        logger.info("Subtraction result: {} - {} = {}", a, b, result);
        return result;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
        logger.debug("Received request for multiplication with parameters: a={}, b={}", a, b);
        double result = calculator.multiply(a, b);
        logger.info("Multiplication result: {} * {} = {}", a, b, result);
        return result;
    }

    @GetMapping("/divide")
    public ResponseEntity<String> divide(@RequestParam double a, @RequestParam double b) {
        logger.debug("Received request for division with parameters: a={}, b={}", a, b);

        try {
            if (b == 0) {
                logger.error("Attempted to divide by zero: {} / {}", a, b);
                return ResponseEntity.badRequest().body("Cannot divide by zero");
            }

            double result = calculator.divide(a, b);
            logger.info("Division result: {} / {} = {}", a, b, result);
            return ResponseEntity.ok(String.valueOf(result));

        } catch (ArithmeticException e) {
            logger.error("Error during division: {}", e.getMessage());
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        }
    }
}

