package in.sp.main;

import in.sp.beans.Employee;
import in.sp.mappers.EmployeeRowMapper;
import in.sp.resources.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

//        -----INSERT OPERATION-----
//        String employee_id = "102";
//        String employee_name = "Ram";
//        String employee_department = "Electrical";
//        String insert_sql_query = "INSERT INTO employees values(?,?,?)";
//        int count = jdbcTemplate.update(insert_sql_query, employee_id, employee_name, employee_department);
//        if (count > 0) {
//            System.out.println("Insertion Success");
//        } else {
//            System.out.println("Insertion Failed");
//        }
//
//        ----UPDATE OPERATION----
//        String employee_id = "101";
//        String employee_department = "BioScience";
//        String update_sql_query = "UPDATE employees SET department=? WHERE id=?";
//        int count = jdbcTemplate.update(update_sql_query,employee_department,employee_id);
//        if(count>0)
//        {
//            System.out.println("Update Success");
//        }
//        else
//        {
//            System.out.println("Update Failed");
//        }
//
//        ----DELETE OPERATION----
//        int employee_id = 102;
//        String delete_query = "DELETE FROM employees WHERE id = ?";
//        int count = jdbcTemplate.update(delete_query,employee_id);
//        if(count>0)
//        {
//           System.out.println("Delete Success");
//        }
//        else
//        {
//           System.out.println("Delete Failed");
//         }

        //----SELECT OPERATION
        String select_sql_query = "SELECT * FROM employees";
        List<Employee> emp_list = jdbcTemplate.query(select_sql_query, new EmployeeRowMapper());
        for(Employee emp:emp_list)
        {
            System.out.println("ID :"+emp.getId());
            System.out.println("ID :"+emp.getName());
            System.out.println("ID :"+emp.getDepartment());
            System.out.println("---------------------------");
        }
    }
}
