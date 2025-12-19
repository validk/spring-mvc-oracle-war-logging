package com.example.hello.dao;

public interface HelloDao {
    String getDbTime();
    long getDbTimeLatencyMs();  // <- MUST be added
}
