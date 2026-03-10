package user_profile_management;

public class App {

    public static void main(String[] args) {

        UserServices service = new UserServices();

        service.addUser(
                "alice",
                "alice@example.com",
                "1234567890",
                "Female",
                "1995-05-10"
        );

        service.searchUser(1);
    }
}