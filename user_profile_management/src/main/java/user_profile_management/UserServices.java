package user_profile_management;

public class UserServices {

    UserDAO dao = new UserDAO();

    public void addUser(String username, String email,
                        String phone, String gender, String dob) {

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);

        Profile profile = new Profile();
        profile.setPhone(phone);
        profile.setGender(gender);
        profile.setDob(dob);

        user.setProfile(profile);
        profile.setUser(user);

        dao.addUser(user);
    }

    public void searchUser(int id) {

        User user = dao.getUserById(id);

        if(user == null) {
            System.out.println("No user found");
            return;
        }

        System.out.println("ID: " + user.getId());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());

        Profile p = user.getProfile();

        System.out.println("Profile:");
        System.out.println("Phone: " + p.getPhone());
        System.out.println("Gender: " + p.getGender());
        System.out.println("DOB: " + p.getDob());
    }

}