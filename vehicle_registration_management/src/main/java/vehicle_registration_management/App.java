package vehicle_registration_management;

public class App {

    public static void main(String[] args) {

        VehicleServices service = new VehicleServices();

        service.addVehicle(
                "Toyota",
                "Corolla",
                "ABC1234",
                "2026-12-31"
        );

        service.searchVehicle(1);

    }
}