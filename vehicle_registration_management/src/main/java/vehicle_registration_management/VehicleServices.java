package vehicle_registration_management;

public class VehicleServices {

    VehicleDAO dao = new VehicleDAO();

    public void addVehicle(String brand, String model,
                           String regNumber, String expiryDate) {

        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(brand);
        vehicle.setModel(model);

        Registration reg = new Registration();
        reg.setRegistrationNumber(regNumber);
        reg.setExpiryDate(expiryDate);

        vehicle.setRegistration(reg);
        reg.setVehicle(vehicle);

        dao.addVehicle(vehicle);
    }

    public void searchVehicle(int id) {

        Vehicle v = dao.getVehicleById(id);

        if(v == null) {
            System.out.println("No vehicle found");
            return;
        }

        System.out.println("ID: " + v.getId());
        System.out.println("Brand: " + v.getBrand());
        System.out.println("Model: " + v.getModel());

        Registration r = v.getRegistration();

        System.out.println("Registration:");
        System.out.println("Number: " + r.getRegistrationNumber());
        System.out.println("Expiry Date: " + r.getExpiryDate());
    }
}