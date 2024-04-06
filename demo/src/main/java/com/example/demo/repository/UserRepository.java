package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.example.demo.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean isValidUser(String userId, String password) {

        User result = jdbcTemplate.queryForObject(String.format("select * from users where email = '%s' and password = '%s'", userId, password), new RowMapper<User>() {

            @Override            
            public User mapRow(ResultSet arg0, int arg1) throws SQLException {                
                User user = new User();
                user.setEmail(arg0.getString("email"));
                user.setFirstName(arg0.getString("first_name"));
                user.setLastName(arg0.getString("last_name"));
                return user;
            }

        });
        return result != null;
    }
}
