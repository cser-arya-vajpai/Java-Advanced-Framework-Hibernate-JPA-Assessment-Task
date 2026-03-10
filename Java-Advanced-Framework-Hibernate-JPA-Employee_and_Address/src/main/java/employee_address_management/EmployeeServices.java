package employee_address_management;

public class EmployeeServices {

    EmployeeDAO dao = new EmployeeDAO();

    public void addEmployee(String name, String email, double salary,
                            String street, String city, String zipcode) {

        // Create Employee object
        Employee emp = new Employee();
        emp.setName(name);
        emp.setEmail(email);
        emp.setSalary(salary);

        // Create Address object
        Address addr = new Address();
        addr.setStreet(street);
        addr.setCity(city);
        addr.setZipcode(zipcode);

        // Link address with employee
        emp.setAddress(addr);
        addr.setEmployee(emp);   // important for bidirectional mapping

        // Save to database
        dao.addEmployee(emp);
    }

    public void searchEmployee(int id) {

        Employee emp = dao.getEmployeeById(id);

        if(emp == null) {
            System.out.println("No employee found.");
            return;
        }

        System.out.println("ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());
        System.out.println("Email: " + emp.getEmail());
        System.out.println("Salary: " + emp.getSalary());

        Address a = emp.getAddress();

        if(a != null) {
            System.out.println("Address:");
            System.out.println("Street: " + a.getStreet());
            System.out.println("City: " + a.getCity());
            System.out.println("Zipcode: " + a.getZipcode());
        }
    }
}