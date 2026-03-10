package employee_address_management;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmployeeDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeePU");
    EntityManager em = emf.createEntityManager();

    public void addEmployee(Employee emp) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(emp);

        et.commit();

        System.out.println("Employee added successfully");
    }

    public Employee getEmployeeById(int id) {

        return em.find(Employee.class, id);
    }

    public void updateSalary(int id, double newSalary) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Employee emp = em.find(Employee.class, id);

        if(emp != null) {
            emp.setSalary(newSalary);
            em.merge(emp);
            System.out.println("Employee salary updated successfully");
        }
        else {
            System.out.println("No employee found.");
        }

        et.commit();
    }

    public void deleteEmployee(int id) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Employee emp = em.find(Employee.class, id);

        if(emp != null) {
            em.remove(emp);
            System.out.println("Employee deleted successfully");
        }
        else {
            System.out.println("No employee found.");
        }

        et.commit();
    }

}