package author_biography_management;

public class App {

    public static void main(String[] args) {

        AuthorServices service = new AuthorServices();

        service.addAuthor(
                "JK Rowling",
                "jk@example.com",
                "Famous author of Harry Potter",
                "Yate",
                "1965-07-31"
        );

        service.searchAuthor(1);

    }
}