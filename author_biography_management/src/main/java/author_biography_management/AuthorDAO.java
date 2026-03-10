package author_biography_management;

import jakarta.persistence.*;

public class AuthorDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("authorPU");

    EntityManager em = emf.createEntityManager();

    public void addAuthor(Author author) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(author);

        et.commit();

        System.out.println("Author added successfully");
    }

    public Author getAuthorById(int id) {

        return em.find(Author.class, id);
    }

    public void deleteAuthor(int id) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Author author = em.find(Author.class, id);

        if(author != null) {
            em.remove(author);
            System.out.println("Author deleted successfully");
        }
        else {
            System.out.println("No author found");
        }

        et.commit();
    }

}