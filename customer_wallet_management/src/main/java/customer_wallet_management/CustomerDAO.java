package customer_wallet_management;

import jakarta.persistence.*;

public class CustomerDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("customerPU");

    EntityManager em = emf.createEntityManager();

    public void addCustomer(Customer customer) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(customer);

        et.commit();

        System.out.println("Customer added successfully");
    }

    public Customer getCustomerById(int id) {

        return em.find(Customer.class, id);
    }

    public void updateWalletBalance(int id, double newBalance) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Customer c = em.find(Customer.class, id);

        if(c != null) {

            c.getWallet().setBalance(newBalance);
            em.merge(c);

            System.out.println("Wallet updated successfully");
        }
        else {
            System.out.println("No customer found");
        }

        et.commit();
    }

    public void deleteCustomer(int id) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Customer c = em.find(Customer.class, id);

        if(c != null) {
            em.remove(c);
            System.out.println("Customer deleted successfully");
        }
        else {
            System.out.println("No customer found");
        }

        et.commit();
    }
}