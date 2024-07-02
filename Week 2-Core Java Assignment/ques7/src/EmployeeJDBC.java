import java.sql.*;

public class EmployeeJDBC
{
    public static void main(String []args) 
    {
        //Database URL and credentials
        String url = "jdbc:mysql://localhost:3306/java_assignment";
        String username = "root";
        String password = "*******";

        //Loading Drivers
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        //Establish the connection
        try(Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Connected to the database");

        //Inserting
        String query1 = "INSERT INTO employees(id, name, department) VALUES (20112014, 'Suresh', 'Mechanical')";
        Statement stmt = connection.createStatement();
        int rowsAffected1 = stmt.executeUpdate(query1); //For insert,update,delete
        if(rowsAffected1>0)
        {
            System.out.println("Insert Successfully. "+ rowsAffected1 + " row affected.");
        }else{
            System.out.println("Insertion Failed");
        }

        //Retrieving
        String query2 = "Select * from employees";
        ResultSet rs  = stmt.executeQuery(query2); //To retrieve data
        while(rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String department = rs.getString("department");
            System.out.println("================================");
            System.out.println("ID: "+id);
            System.out.println("Name: "+name);
            System.out.println("Department: "+department);
        }

        //Deleting (ID is primary key)
        String query3 = "DELETE FROM employees where id = 20112011";
        int rowsAffected2 = stmt.executeUpdate(query3);
        if(rowsAffected2>0)
        {
            System.out.println("Delete Successfully. "+ rowsAffected2 + " row affected.");
        }else{
            System.out.println("Deletion Failed");
        }

        //Updating
        String query4 = "UPDATE employees SET department='BioScience' WHERE id = 20112014";
        int rowsAffected3 = stmt.executeUpdate(query4);
        if(rowsAffected3>0)
        {
            System.out.println("Update Successfully. "+ rowsAffected3 + " row affected.");
        }else{
            System.out.println("Update Failed");
        }

        rs.close();
        stmt.close();
        connection.close();
        System.out.println("Connection closed successfully");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}