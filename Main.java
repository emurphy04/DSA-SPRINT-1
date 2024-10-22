import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        boolean isLogged = false;
        ArrayList<User> users = new ArrayList<User>();
        User currUser = new User(null);

        while(running){
            while(!isLogged){
                System.out.println();
                System.out.println("-----------------------------------");
                System.out.println("Welcome!");
                System.out.println("1. Login");
                System.out.println("2. Create new user");
                System.out.println();
                String choice = input.nextLine();
    
                switch (choice) {
                    case "1":
                        boolean userFound = false;
                        System.out.println();
                        System.out.println("Enter your username: ");
                        String userName = input.nextLine();
                        for (int i = 0; i < users.size(); i++) {
                            if (users.get(i).getName().equals(userName)) {
                                currUser = users.get(i);
                                userFound = true;
                                isLogged = true;
                                break;
                            }
                        }
    
                        if (!userFound) {
                            System.out.println("User does not exist, please try again.");
                        }
                        break;
                    
                    case "2":
                        userFound = false;
                        System.out.println();
                        System.out.println("Enter a username: ");
                        userName = input.nextLine();
                        for (int i = 0; i < users.size(); i++) {
                            if (users.get(i).getName().equals(userName)) {
                                System.out.println("User already exists, please try again.");
                                userFound = true;
                            }
                        }
    
                        if (!userFound) {
                            users.add(new User(userName));
                            System.out.println("User added!");
                        }                    
                        break;
                
                    default:
                        System.out.println("Invalid input, please try again...");
                        break;
                }
            }
                
            while(isLogged){
                System.out.println();
                System.out.println(currUser.getName()+"'s To Do: ");
                currUser.list.getListIncomplete();
                System.out.println("-----------------------------------");
                System.out.println("1. Add Task");
                System.out.println("2. Mark as complete");
                System.out.println("3. See all completed tasks");
                System.out.println("4. Log out");
                System.out.println("5. Exit");
                String choice = input.nextLine();
    
                switch (choice) {
                    case "1":
                        System.out.println();
                        System.out.println("Enter the description of the task you would like to add:");
                        String desc = input.nextLine();
                        currUser.list.addTask(desc);
                        System.out.println("Added task!");
                        break;
    
                    case "2":
                        System.out.println();
                        System.out.println("Print the number of the task you want to mark as complete:");
                        int num = input.nextInt();
                        num = num - 1;
                        currUser.list.completeTask(num);
                        break;
    
                    case "3":
                        System.out.println();
                        System.out.println(currUser.getName()+"'s Completed Tasks:");
                        System.out.println("-----------------------------------");
                        currUser.list.getListComplete();
                        System.out.println("-----------------------------------");
                        break;

                    case "4":
                        isLogged = false;
                        break;

                    case "5":
                        System.out.println("Are you sure you want to quit? Y/N");
                        String quit = input.nextLine().toLowerCase();
                        switch (quit) {
                            case "y":
                                System.out.println("Have a nice day!");
                                System.exit(0);
                                break;
                            
                            case "n":
                                System.out.println();
                                break;
                        
                            default:
                                break;
                        }
                        break;
                
                    default:
                        break;
                }
            }
        }
        input.close();
    }
}
