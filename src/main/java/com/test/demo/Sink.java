package com.test.demo;

public class Sink {
    private String invokeType;
    private String invokeMethod;
    private String sinkMethod;

    public Sink(String invokeType, String invokeMethod, String sinkMethod) {
        this.invokeType = invokeType;
        this.invokeMethod = invokeMethod;
        this.sinkMethod = sinkMethod;
    }

    public Sink() {

    }

    public String getInvokeType() {
        return invokeType;
    }

    public void setInvokeType(String invokeType) {
        this.invokeType = invokeType;
    }

    public String getInvokeMethod() {
        return invokeMethod;
    }

    public void setInvokeMethod(String invokeMethod) {
        this.invokeMethod = invokeMethod;
    }

    public String getSinkMethod() {
        return sinkMethod;
    }

    public void setSinkMethod(String sinkMethod) {
        this.sinkMethod = sinkMethod;
    }

    @Override
    public String toString() {
        return "Sink{" +
                "invokeType='" + invokeType + '\'' +
                ", invokeMethod='" + invokeMethod + '\'' +
                ", sinkMethod='" + sinkMethod + '\'' +
                '}';
    }
}
