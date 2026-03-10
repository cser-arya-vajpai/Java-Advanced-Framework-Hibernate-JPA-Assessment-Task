package vehicle_registration_management;

import jakarta.persistence.*;

public class VehicleDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("vehiclePU");

    EntityManager em = emf.createEntityManager();

    public void addVehicle(Vehicle vehicle) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(vehicle);

        et.commit();

        System.out.println("Vehicle added successfully");
    }

    public Vehicle getVehicleById(int id) {

        return em.find(Vehicle.class, id);
    }

    public void updateExpiry(int id, String newExpiryDate) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Vehicle vehicle = em.find(Vehicle.class, id);

        if(vehicle != null) {

            vehicle.getRegistration().setExpiryDate(newExpiryDate);
            em.merge(vehicle);

            System.out.println("Registration updated successfully");
        }
        else {
            System.out.println("No vehicle found");
        }

        et.commit();
    }

    public void deleteVehicle(int id) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Vehicle vehicle = em.find(Vehicle.class, id);

        if(vehicle != null) {
            em.remove(vehicle);
            System.out.println("Vehicle deleted successfully");
        }
        else {
            System.out.println("No vehicle found");
        }

        et.commit();
    }
}