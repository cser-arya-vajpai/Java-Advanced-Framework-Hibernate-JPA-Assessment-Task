package customer_wallet_management;

public class App {

    public static void main(String[] args) {

        CustomerServices service = new CustomerServices();

        service.addCustomer(
                "Bob",
                "bob@example.com",
                1500,
                "USD"
        );

        service.searchCustomer(1);

    }
}