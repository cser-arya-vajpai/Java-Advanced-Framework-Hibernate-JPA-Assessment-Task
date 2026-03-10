package employee_address_management;

public class App {

    public static void main(String[] args) {

        EmployeeServices service = new EmployeeServices();

        service.addEmployee(
                "John Doe",
                "john@example.com",
                50000,
                "123 Main St",
                "New York",
                "10001"
        );

        service.searchEmployee(1);
    }
}