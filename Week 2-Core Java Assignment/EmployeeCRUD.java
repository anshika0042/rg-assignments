import java.util.ArrayList;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee() {}

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "'}";
    }
}

public class EmployeeCRUD {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getEmployee(int index) {
        if (index >= 0 && index < employees.size()) {
            return employees.get(index);
        }
        return null;
    }

    public void updateEmployee(int index, Employee newEmployee) {
        if (index >= 0 && index < employees.size()) {
            employees.set(index, newEmployee);
        }
    }

    public void deleteEmployee(int index) {
        if (index >= 0 && index < employees.size()) {
            employees.remove(index);
        }
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        EmployeeCRUD employeeCRUD = new EmployeeCRUD();

        Employee e1 = new Employee(20112011, "Ram", "IT");
        Employee e2 = new Employee(20112012, "Shyam", "Electrical");
        Employee e3 = new Employee(20112013, "Ramesh", "Chemical");

        // Create
        employeeCRUD.addEmployee(e1);
        employeeCRUD.addEmployee(e2);
        employeeCRUD.addEmployee(e3);

        // Read
        System.out.println("First Employee:");
        Employee emp = employeeCRUD.getEmployee(0);
        if (emp != null) {
            System.out.println(emp);
        }

        // Update
        Employee e4 = new Employee(20112014, "Suresh", "Mechanical");
        employeeCRUD.updateEmployee(2, e4);

        // Delete
        employeeCRUD.deleteEmployee(0);

        // Display all employees
        System.out.println("After removing first employee:");
        employeeCRUD.printAllEmployees();
    }
}
