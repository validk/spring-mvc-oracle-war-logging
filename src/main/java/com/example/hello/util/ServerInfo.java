package com.example.hello.util;

public final class ServerInfo {

    private ServerInfo() {}

    public static String getManagedServerName() {
        return System.getProperty("weblogic.Name", "unknown-ms");
    }

    public static String getPodName() {
        return System.getenv().getOrDefault("HOSTNAME", "unknown-pod");
    }

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }
}

