package com.example.hello.dao;

import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDaoImpl implements HelloDao {

    private static final Logger log =
        LogManager.getLogger(HelloDaoImpl.class);

    private final JdbcTemplate jdbcTemplate;

    public HelloDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public String getDbTime() {
        log.debug("Querying Oracle DB for SYSDATE");
        return jdbcTemplate.queryForObject(
            "SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') FROM DUAL",
            String.class);
    }
}