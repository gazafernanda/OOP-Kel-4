import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = new Connection("Databasee.csv");
        UserRepository userRepository = new UserRepository();
        TeamRepository teamRepository = new TeamRepository();

        while (true) {
            System.out.println("1. Menu Utama");
            System.out.println("2. Insert Data");
            System.out.println("3. Show");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    System.out.println("Which table to insert? 1. User, 2. Team.");
                    int tableChoice = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("add name:");
                    String name = scanner.nextLine();
                    System.out.println("add nim:");
                    String nim = scanner.nextLine();
                    System.out.println("add team:");
                    String teamName = scanner.nextLine();

                    if (tableChoice == 1) {
                        User newUser = userRepository.insert(new String[]{name, nim, teamName}, connection);
                        if (newUser != null) {
                            System.out.println("User created!");
                        } else {
                            System.out.println("Error: Failed to create user.");
                        }
                    } else if (tableChoice == 2) {
                        Team newTeam = teamRepository.insert(new String[]{teamName}, connection);
                        if (newTeam != null) {
                            System.out.println("Team created!");
                        } else {
                            System.out.println("Error: Failed to create team.");
                        }
                    } else {
                        System.out.println("Invalid choice. Please enter 1 or 2.");
                    }
                    break;
                case 3:
                    System.out.println("Which table to show? 1. User, 2. Team.");
                    int showChoice = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Want to filter by condition? 1. Yes, 2. No.");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine(); 

                    if (filterChoice == 1) {
                        System.out.println("add condition, separate by semicolon.");
                        String conditionInput = scanner.nextLine();
                        String[] conditions = conditionInput.split(";");
                    } else if (filterChoice == 2) {
                    	
                    } else {
                        System.out.println("Invalid choice. Please enter 1 or 2.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid");
            }
        }
    }
}