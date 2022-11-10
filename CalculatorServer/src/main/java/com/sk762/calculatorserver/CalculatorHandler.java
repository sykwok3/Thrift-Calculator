package com.gp225.calculatorserver;

import calculator.CalculatorService;
import calculator.DivideByZeroException;
import org.apache.thrift.TException;

public class CalculatorHandler implements CalculatorService.Iface {

    @Override
    public int add(int n1, int n2) throws TException {
        System.out.println("add(" + n1 + "," + n2 + ") called in Thread " + Thread.currentThread().getId());
        return n1 + n2;
    }

    @Override
    public int subtract(int n1, int n2) throws TException {
        System.out.println("subtract(" + n1 + "," + n2 + ") called in Thread " + Thread.currentThread().getId());
        return n1 - n2;
    }
    
    @Override
    public int multiply(int n1, int n2) throws TException {
        System.out.println("Multiply(" + n1 + "," + n2 + ") called in Thread " + Thread.currentThread().getId());
        return n1 * n2;
    }

    @Override
    public int divide(int n1, int n2) throws DivideByZeroException, TException {
        System.out.println("divide(" + n1 + "," + n2 + ") called in Thread " + Thread.currentThread().getId());
        if(n2 == 0) {
            System.out.println("DivideByZeroException will be thrown");
            throw new DivideByZeroException("you cannot divide by zero", n1, n2);
        }
        return n1 / n2;
    }

}
