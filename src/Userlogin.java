import java.util.Scanner;

public class Userlogin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean isAuthenticated = Authentication.authenticate(username, password);

        if (isAuthenticated) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }

        scanner.close();
    }
<<<<<<< HEAD

=======
>>>>>>> 7e26c47438836f4cc3109bc2103a6db020b6f076
}

