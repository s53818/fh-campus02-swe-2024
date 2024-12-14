package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.parser.Parser;

import java.util.Arrays;
import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    public double performSingleOperation(Operation op) throws CalculatorException {
        double a = pop();

        return switch (op) {
            case sin -> Math.sin(a * Math.PI / 180);
            case cos -> Math.cos(a * Math.PI / 180);
            default -> 0;
        };

    }

    @Override
    public double perform(Operation op) throws CalculatorException {

        if(op == Operation.dotProduct) return performDotProduct();

        if(op == Operation.sin || op == Operation.cos) return performSingleOperation(op);

        double b = pop();
        double a = pop();

        switch (op) {
            case add:
                return a + b;
            case sub:
                return a - b;
            case div:
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                return a * b;
            case mod:
                double mod = a % b;
                if(Double.isNaN(mod))
                    throw new CalculatorException("Modulo by zero");
                return mod;
        }
        return 0;
    }

    @Override
    public double performDotProduct() throws CalculatorException
    {
        if (stack_.isEmpty())
            throw new CalculatorException();

        double dimensions = stack_.pop();
        int size = stack_.size();
        double[] stack = new double[size];
        int result = 0;

        for (int i = 0; i < size; i++) {
            stack[i] = stack_.pop();
        }

        for(int i = 0; i < stack.length/2; i++) {
            result = (int) (result + (stack[i] * stack[i+(int)dimensions]));
        }

        return result;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

}
