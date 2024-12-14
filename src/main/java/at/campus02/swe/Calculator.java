package at.campus02.swe;

import at.campus02.swe.parser.Parser;

public interface Calculator {

    enum Operation {
        add, sub, mul, div, mod, sin, cos, dotProduct,
    };

    void push(double value);

    double pop() throws CalculatorException;

    double perform(Operation op) throws CalculatorException;

    double performDotProduct() throws CalculatorException;

    void clear();
}