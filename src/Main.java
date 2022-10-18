import com.infosys.bean.Employee;
import com.infosys.dao.MysqlDao;
import com.infosys.dao.MysqlDaoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("=======MENU=====");
        System.out.println("1.Add employee");
        System.out.println("2.Remove employee");
        System.out.println("3.Display employees");
        System.out.println("==================");
        System.out.println("please enter your choice");
        Scanner scanner= new Scanner(System.in);
        int option= scanner.nextInt();
        if(option==1){
            MysqlDao dao= new MysqlDaoImpl();
            //dao.addEmployee();
            System.out.println("please enter employee id :");
            int id= scanner.nextInt();
            System.out.println("please enter employee name :");
            String name= scanner.next();
            System.out.println("please enter employee salary :");
            int salary= scanner.nextInt();

            Employee employee= new Employee(id,name,salary);
            try {
                dao.addEmployee(employee);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else if(option==2){

        }else if(option==3){
            MysqlDao dao= new MysqlDaoImpl();
            List<Employee> empList=dao.displayEmployee();
            System.out.println("=========================");
            for (Employee e:empList ) {
                System.out.println(e);
            }
            System.out.println("=========================");
        }else{
            System.out.println("Invalid option");
        }


    }
}