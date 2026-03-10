package author_biography_management;

public class AuthorServices {

    AuthorDAO dao = new AuthorDAO();

    public void addAuthor(String name, String email,
                          String summary, String birthPlace, String birthDate) {

        Author author = new Author();
        author.setName(name);
        author.setEmail(email);

        Biography bio = new Biography();
        bio.setSummary(summary);
        bio.setBirthPlace(birthPlace);
        bio.setBirthDate(birthDate);

        author.setBiography(bio);
        bio.setAuthor(author);

        dao.addAuthor(author);
    }

    public void searchAuthor(int id) {

        Author author = dao.getAuthorById(id);

        if(author == null) {
            System.out.println("No author found");
            return;
        }

        System.out.println("ID: " + author.getId());
        System.out.println("Name: " + author.getName());
        System.out.println("Email: " + author.getEmail());

        Biography b = author.getBiography();

        System.out.println("Biography:");
        System.out.println("Summary: " + b.getSummary());
        System.out.println("Birth Place: " + b.getBirthPlace());
        System.out.println("Birth Date: " + b.getBirthDate());
    }

}