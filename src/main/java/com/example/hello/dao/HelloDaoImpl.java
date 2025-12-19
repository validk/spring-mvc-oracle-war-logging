package com.example.hello.dao;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDaoImpl implements HelloDao {

    private final JdbcTemplate jdbcTemplate;

    public HelloDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public String getDbTime() {
        return jdbcTemplate.queryForObject(
            "SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') FROM DUAL",
            String.class
        );
    }

    @Override
    public long getDbTimeLatencyMs() {
        long start = System.currentTimeMillis();

        jdbcTemplate.queryForObject(
            "SELECT SYSDATE FROM DUAL",
            java.util.Date.class
        );

        return System.currentTimeMillis() - start;
    }
}
