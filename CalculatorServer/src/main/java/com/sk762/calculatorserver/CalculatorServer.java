package com.gp225.calculatorserver;

import calculator.CalculatorService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class CalculatorServer {

    public static CalculatorHandler handler;
    public static CalculatorService.Processor processor;
    public static TServerTransport serverTransport;
    public static TServer server;

    public static void main(String[] args) {
        try {
            handler = new CalculatorHandler();
            processor = new CalculatorService.Processor(handler);

            Runnable simple = new Runnable() {
                @Override
                public void run() {
                    simple(processor);
                }
            };

            new Thread(simple).start();
            System.in.read();
            server.stop();
            
        } catch (Exception x) {
            System.err.println(x);
        }
    }

    public static void simple(CalculatorService.Processor processor) {
        try {
            serverTransport = new TServerSocket(9090);
            server = new TSimpleServer(new Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server in Thread " + Thread.currentThread().getId());
            server.serve();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
