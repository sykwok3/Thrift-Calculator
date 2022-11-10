package com.gp225.calculatorclient;

import calculator.CalculatorService;
import calculator.DivideByZeroException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class CalculatorClient {

    public static void main(String[] args) {
        double result;
        int arg1;
        int arg2;

        try {
            TTransport transport;

            transport = new TSocket("localhost", 9090);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            CalculatorService.Client client = new CalculatorService.Client(protocol);

            /**
             * ******************************ADDITION*********************************
             */
            arg1 = 3;
            arg2 = 5;
            // use the stub method to call the RPC Server - this is a blocking call
            result = client.add(arg1, arg2);
            // after receiving the result the call above will un-block
            // print the result
            System.out.println("RPC Call: " + arg1 + " + " + arg2 + " = " + result);

            /**
             * ******************************SUBTRACTION******************************
             */
            arg1 = 3;
            arg2 = 5;
            // use the stub method to call the RPC Server - this is a blocking call
            result = client.subtract(arg1, arg2);
            // after receiving the result the call above will un-block
            // print the result
            System.out.println("RPC Call: " + arg1 + " - " + arg2 + " = " + result);

            /**
             * ***************************MULTIPLICATION******************************
             */
            arg1 = 3;
            arg2 = 5;
            // use the stub method to call the RPC Server - this is a blocking call
            result = client.multiply(arg1, arg2);
            // after receiving the result the call above will un-block
            // print the result
            System.out.println("RPC Call: " + arg1 + " * " + arg2 + " = " + result);

            /**
             * ******************************DIVISION*********************************
             */
            arg1 = 3;
            arg2 = 0;
            // use the stub method to call the RPC Server - this is a blocking call
            result = client.divide(arg1, arg2);
            // after receiving the result the call above will un-block
            // print the result
            System.out.println("RPC Call: " + arg1 + " / " + arg2 + " = " + result);

            //close transport
            transport.close();

        } catch (DivideByZeroException y) {
            System.err.println(y);
        } catch (TException x) {
            System.err.println(x);
        }
    }
}
