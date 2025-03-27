
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}

class UserRepository {
    public void save(User user) {
        System.out.println("Sla gebruiker op in  database: " + user.getName());
    }
}

class EmailService {
    public void sendWelcomeEmail(User user) {
        System.out.println("Stuur email naar: " + user.getEmail());
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("Alice", "alice@example.com");
        UserRepository userRepository = new UserRepository();
        EmailService emailService = new EmailService();

        userRepository.save(user);
        emailService.sendWelcomeEmail(user);
    }
}
