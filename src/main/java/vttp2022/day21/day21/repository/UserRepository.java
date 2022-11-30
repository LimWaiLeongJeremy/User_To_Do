package vttp2022.day21.day21.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.day21.day21.model.User;

import static vttp2022.day21.day21.repository.Query.*;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createUser(User user){
        return jdbcTemplate.update(SQL_INERT_USER, user.getUsername(), user.getPassword(), user.getEmail(), user.getDob());
    }

    public boolean authenticate(User user){
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_AUTHENTICATE_USER, user.getUsername(), user.getPassword());

        if (rs.next())
            return rs.getBoolean("auth_state");

        return false;
    }

}
