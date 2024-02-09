package org.example.services;

import org.springframework.stereotype.Service;

import static org.example.services.Operation.*;

@Service
public class CalcService {

    public int calculate(String op, int num1, int num2) {
        Operation operation = Operation.valueOf(op.toUpperCase());
        return switch (operation) {
            case SUM -> num1 + num2;
            case DIV -> num1 / num2;
            case DIF -> num1 - num2;
            case MUL -> num1 * num2;
        };
    }
}
