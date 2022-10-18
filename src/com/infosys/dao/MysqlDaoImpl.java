package com.infosys.dao;

import com.infosys.bean.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlDaoImpl implements MysqlDao{

    public static final String DRIVER_NAME="com.mysql.jdbc.Driver";
    public static final String DB_URL="jdbc:mysql://localhost:3306/sudheer?characterEncoding=latin1";
    public static final String USER_ID="root";
    public static final String PASSWORD="Hithika#19";



    private Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(DB_URL, USER_ID, PASSWORD);
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Override
    public void addEmployee(Employee employee) throws SQLException {
        Connection connection=getConnection();
        Statement statement=connection.createStatement();
       int result= statement.executeUpdate("insert into employee values(" +
                employee.getId() + "," +
                "'"+employee.getName()+"'" + "," +
                employee.getSalary() + ")");
       if(result>0){
           System.out.println("successfully added!");
       }

    }

    @Override
    public void removeEmployee(int id) {

    }

    @Override
    public List<Employee> displayEmployee() throws SQLException {
        Connection connection=getConnection();
        Statement statement=connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from employee");
        List<Employee> employeeList= new ArrayList<Employee>();
        while (rs.next()) {
            int empId=rs.getInt(1);
            String name=rs.getString(2);
            double salary=rs.getInt(3);
            Employee employee= new Employee(empId,name,salary);
            employeeList.add(employee);
        }
        return employeeList;
    }
}
