package product_inventory_system;


import java.util.Scanner;

public class ProductController {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {

            System.out.println("\n1.Add Product");
            System.out.println("2.View All Products");
            System.out.println("3.Search Product by ID");
            System.out.println("4.Search Product by Category");
            System.out.println("5.Update Product Price");
            System.out.println("6.Delete Product");
            System.out.println("7.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();

                    if (name.isEmpty() || category.isEmpty() || price <= 0 || quantity <= 0) {
                        System.out.println("Invalid input.");
                        break;
                    }

                    Product p = new Product(name, category, price, quantity);
                    dao.addProduct(p);
                    break;

                case 2:
                    dao.getAllProducts();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    dao.getProductById(id);
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter Category: ");
                    String cat = sc.nextLine();
                    dao.getProductsByCategory(cat);
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    int pid = sc.nextInt();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    dao.updateProductPrice(pid, newPrice);
                    break;

                case 6:
                    System.out.print("Enter ID: ");
                    int deleteId = sc.nextInt();

                    dao.deleteProduct(deleteId);
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}