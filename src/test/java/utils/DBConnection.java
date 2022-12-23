package utils;

import java.sql.*;

public class DBConnection {
    private Connection connect = null;
    private Statement statement = null;

    public void connect() {
        try {
//            connect = DriverManager
//                    .getConnection("jdbc:mysql://localhost/qa_14?user=root&password=Valma#&useSSL=true&serverTimezone=GMT");
            // Statements allow to issue SQL queries to the database
            connect = DriverManager.getConnection("jdbc:mysql://localhost/qa_14", "root", "Valma");
            statement = connect.createStatement();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public ResultSet selectFrom(String tableName) {
        try {
            return statement
                    .executeQuery(String.format("select * from %s", tableName));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public ResultSet select(String query) {
        try {
            return statement
                    .executeQuery(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public int update(String query) {
        try {
            return statement
                    .executeUpdate(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public void delete(String query) {
        try {
             statement
                    .execute(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public ResultSet selectStudent(String studentName) throws SQLException {
        PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM qa_14.students WHERE name = ?");
        preparedStatement.setString(1,studentName);
        return preparedStatement.executeQuery();
    }

    public boolean addStudent(String name, int group_id) throws SQLException {
        PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO qa_14.students (name, group_id) VALUES (?, ?)");
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,group_id);
        return preparedStatement.execute();

    }

    public int updateStudent(int id) {
        return update(
                String.format("UPDATE qa_14.students SET id = %s WHERE id = %s",  id));
    }

    public void deleteStudent(int id) {
        delete(
                String.format("DELETE FROM qa_14.students  WHERE id = %s", id));
    }

    public boolean insert(String query) {
        try {
            return statement
                    .execute(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    // You need to close the resultSet
    public void close() {
        try {

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception ignored) {
        }
    }
}

