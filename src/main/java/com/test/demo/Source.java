package com.test.demo;

public class Source {
    private String invokeType;
    private String invokeMethod;
    private String sourceMethod;

    public Source(String invokeType, String invokeMethod, String sourceMethod) {
        this.invokeType = invokeType;
        this.invokeMethod = invokeMethod;
        this.sourceMethod = sourceMethod;
    }

    public Source() {
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

    public String getSourceMethod() {
        return sourceMethod;
    }

    public void setSourceMethod(String sourceMethod) {
        this.sourceMethod = sourceMethod;
    }

    @Override
    public String toString() {
        return "Source{" +
                "invokeType='" + invokeType + '\'' +
                ", invokeMethod='" + invokeMethod + '\'' +
                ", sourceMethod='" + sourceMethod + '\'' +
                '}';
    }
}
