package customer_wallet_management;

public class CustomerServices {

    CustomerDAO dao = new CustomerDAO();

    public void addCustomer(String name, String email,
                            double balance, String currency) {

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);

        Wallet wallet = new Wallet();
        wallet.setBalance(balance);
        wallet.setCurrency(currency);

        customer.setWallet(wallet);
        wallet.setCustomer(customer);

        dao.addCustomer(customer);
    }

    public void searchCustomer(int id) {

        Customer c = dao.getCustomerById(id);

        if(c == null) {
            System.out.println("No customer found");
            return;
        }

        System.out.println("ID: " + c.getId());
        System.out.println("Name: " + c.getName());
        System.out.println("Email: " + c.getEmail());

        Wallet w = c.getWallet();

        System.out.println("Wallet:");
        System.out.println("  Balance: " + w.getBalance());
        System.out.println("  Currency: " + w.getCurrency());
    }
}