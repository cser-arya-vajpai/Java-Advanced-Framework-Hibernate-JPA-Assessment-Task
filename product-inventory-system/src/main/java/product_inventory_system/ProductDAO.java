package product_inventory_system;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ProductDAO {

    EntityManager entityManager = Persistence
            .createEntityManagerFactory("product-unit")
            .createEntityManager();

    EntityTransaction transaction = entityManager.getTransaction();

    // Add Product
    public void addProduct(Product p) {

        transaction.begin();
        entityManager.persist(p);
        transaction.commit();

        System.out.println("Product added successfully.");
        displayProduct(p);
    }

    // Get All Products
    public void getAllProducts() {

        Query query = entityManager.createQuery("SELECT p FROM Product p");

        List<Product> products = query.getResultList();

        if (products.isEmpty()) {
            System.out.println("No product found.");
        } else {
            for (Product p : products) {
                displayProduct(p);
            }
        }
    }

    // Get Product by ID
    public void getProductById(int id) {

        Product p = entityManager.find(Product.class, id);

        if (p == null) {
            System.out.println("No product found.");
        } else {
            displayProduct(p);
        }
    }

    // Get Products by Category
    public void getProductsByCategory(String category) {

        Query query = entityManager.createQuery(
                "SELECT p FROM Product p WHERE p.category = :category");

        query.setParameter("category", category);

        List<Product> list = query.getResultList();

        if (list.isEmpty()) {
            System.out.println("No product found.");
        } else {
            for (Product p : list) {
                displayProduct(p);
            }
        }
    }

    // Update Price
    public void updateProductPrice(int id, double newPrice) {

        Product p = entityManager.find(Product.class, id);

        if (p == null) {
            System.out.println("No product found.");
            return;
        }

        transaction.begin();
        p.setPrice(newPrice);
        entityManager.merge(p);
        transaction.commit();

        System.out.println("Product price updated successfully.");
        displayProduct(p);
    }

    // Delete Product
    public void deleteProduct(int id) {

        Product p = entityManager.find(Product.class, id);

        if (p == null) {
            System.out.println("No product found.");
            return;
        }

        transaction.begin();
        entityManager.remove(p);
        transaction.commit();

        System.out.println("Product deleted successfully.");
    }

    // Display Product
    public void displayProduct(Product p) {

        System.out.println("ID: " + p.getId());
        System.out.println("Name: " + p.getName());
        System.out.println("Category: " + p.getCategory());
        System.out.println("Price: " + p.getPrice());
        System.out.println("Quantity: " + p.getQuantity());
        System.out.println();
    }
}