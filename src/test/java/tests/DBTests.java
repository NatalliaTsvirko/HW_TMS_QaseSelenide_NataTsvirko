package tests;

import org.testng.annotations.Test;
import utils.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTests {

    @Test
    public void test1() throws SQLException {
        DBConnection connection =new DBConnection();
        connection.connect();
        ResultSet resultSet = connection.selectFrom("students");
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int group_id = resultSet.getInt("group_id");
            System.out.println("Id :" + id + "Name: " + name + "Group_id : " + group_id);
        }

        connection.close();

    }

    @Test
    public void test2() throws SQLException {
        DBConnection connection =new DBConnection();
        connection.connect();
        ResultSet resultSet = connection.select("SELECT * FROM qa_14.groups WHERE name = \"qa_14\"");
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("Id :" + id + "Name: " + name );
        }

        connection.close();

    }

    @Test
    public void test3() throws SQLException {
        DBConnection connection =new DBConnection();
        connection.connect();
        String query ="INSERT INTO qa_14.students (name, group_id) VALUES (\"%s\", %s)";
        connection.insert (String.format (query,"Vasya",1));
        connection.close();

    }

    @Test
    public void test4() throws SQLException {
        DBConnection connection =new DBConnection();
        connection.connect();
        connection.addStudent ("Petya",2);
        connection.close();

    }

    @Test
    public void test5() throws SQLException {
        DBConnection connection =new DBConnection();
        connection.connect();
        connection.updateStudent (6);
        connection.close();

    }

    @Test
    public void test6() throws SQLException {
        DBConnection connection =new DBConnection();
        connection.connect();
        ResultSet resultSet =  connection.selectStudent("Petya2");
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int group_id = resultSet.getInt("group_id");
            System.out.println("Id :" + id + "Name: " + name + "Group_id : " + group_id);
        }
        connection.close();

    }
}
