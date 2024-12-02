package pege1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pege2.Student;

/**
 *
 * @author Ang
 */
public class StudentD {
//данные для подключения

    private String url = "jdbc:mysql://127.0.0.1:3306/mydb?zeroDateTimeBehavior=convertToNull";
    private String username = "root";
    private String password = "1234";
//SQL запросы на получение, изменение, удаление данных из таблицы students 
    private static final String INSERT_STUDENTS_SQL = "INSERT INTO students (name, groups_id, email, city) VALUES (?, ?, ?, ?);";
    private static final String SELECT_STUDENTS_BY_ID = "select id,name,groups_id,email,city from students where id =?";
    private static final String SELECT_ALL_STUDENTS = "select students.id, students.name, students.groups_id,groups.name,\n"
            + "students.email,  students.city from students INNER JOIN groups ON students.groups_id = groups.id";
    private static final String DELETE_STUDENTS_SQL = "delete from students where id = ?;";
    private static final String UPDATE_STUDENTS_SQL = "update students set name = ?,groups_id= ?,email= ?, city =? where id = ?;";
    //фильтр по имени и городу
    private static final String SELECT_FILTER_NC_STUDENTS = "select students.id, students.name, students.groups_id,groups.name,\n"
            + "students.email,  students.city from students INNER JOIN groups ON students.groups_id = groups.id where students.name = ? and students.city =?;";

    public StudentD() {
    }
//Подключение к серверу базы данных через JDBC driver

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertStudent(Student student) throws SQLException {
        System.out.println(INSERT_STUDENTS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getGroups_id());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getCity());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Student selectStudent(int id) {
        Student student = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int groups_id = rs.getInt("groups_id");
                String email = rs.getString("email");
                String city = rs.getString("city");
                student = new Student(id, name, groups_id, email, city);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }
    //вывод списка студентов
    public List< Student> selectAllStudents() {
        List< Student> student = new ArrayList<>();
        try (Connection connection = getConnection();
            //использование подготовленного запроса 
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
            System.out.println(preparedStatement);
            //получение результат запроса
            ResultSet rs = preparedStatement.executeQuery();
            //создание студента из полученных данных
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String groups_name = rs.getString("groups.name");
                String email = rs.getString("email");
                String city = rs.getString("city");
                student.add(new Student(id, name, groups_name, email, city));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }
    //удаление студента
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        //выполнение подготовленного SQL запроса удаления
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_STUDENTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL);) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getGroups_id());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getCity());
            statement.setInt(5, student.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    //фильтр по имени и городу
    public List< Student> filterStudent(String nameFind, String cityFind) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List< Student> students = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_FILTER_NC_STUDENTS);) {
            statement.setString(1, nameFind);
            statement.setString(2, cityFind);
            System.out.println(statement);
            // Step 3: Execute the query or update query
            ResultSet rs = statement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String groups_name = rs.getString("groups.name");
                String email = rs.getString("email");
                String city = rs.getString("city");
                students.add(new Student(id, name, groups_name, email, city));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return students;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
