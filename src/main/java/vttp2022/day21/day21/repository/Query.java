package vttp2022.day21.day21.repository;

public class Query {

    public static String SQL_INERT_USER = "insert into users (name, password, email, dob)values (?, SHA(?), ?, ?);";
    public static String SQL_AUTHENTICATE_USER = "SELECT count(*) > 0 as auth_state FROM users where name = ? and password = sha(?);";
    public static String SQL_INSERT_TASK = "insert into task (task_name, priority, assign_to, completion_date) values (?, ?, ?, ?);";
}
