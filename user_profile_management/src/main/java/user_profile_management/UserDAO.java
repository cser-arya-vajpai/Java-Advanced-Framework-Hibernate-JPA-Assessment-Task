package user_profile_management;

import jakarta.persistence.*;

public class UserDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("userPU");

    EntityManager em = emf.createEntityManager();

    public void addUser(User user) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(user);

        et.commit();

        System.out.println("User added successfully");
    }

    public User getUserById(int id) {

        return em.find(User.class, id);
    }

    public void updateEmail(int id, String newEmail) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        User user = em.find(User.class, id);

        if(user != null) {
            user.setEmail(newEmail);
            em.merge(user);
            System.out.println("Email updated successfully");
        }
        else {
            System.out.println("No user found");
        }

        et.commit();
    }

    public void deleteUser(int id) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        User user = em.find(User.class, id);

        if(user != null) {
            em.remove(user);
            System.out.println("User deleted successfully");
        }
        else {
            System.out.println("No user found");
        }

        et.commit();
    }

}