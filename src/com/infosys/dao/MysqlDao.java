package com.infosys.dao;

import com.infosys.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface MysqlDao {
    public abstract void addEmployee(Employee employee) throws SQLException;
    public abstract void removeEmployee(int id);
    public abstract List<Employee> displayEmployee() throws SQLException;
}
