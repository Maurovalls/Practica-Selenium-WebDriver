package org.practica.intermedio.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RealTimeReport implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started : "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Pass : "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed : "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped : "+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Strart Execution : "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("End of Execution (test) : "+context.getName());
    }
}
