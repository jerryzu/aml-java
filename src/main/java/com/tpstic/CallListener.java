package com.tpstic;

public class CallListener implements Event {
    private String name;

    public CallListener(String name) {
        this.name = name;
    }

    public void processEvent(String EventInfo) {
        System.out.println(String.format("%s: %s", name, EventInfo));
    }
}