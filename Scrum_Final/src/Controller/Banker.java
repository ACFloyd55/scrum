package Controller;

import java.util.Scanner;

public class Banker {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        User user = new User(username, password);

        System.out.print("Re-enter username: ");
        String loginUser = scanner.next();
        System.out.print("Re-enter password: ");
        String loginPass = scanner.next();

        if (!user.authenticate(loginUser, loginPass)) {
            System.out.println("Authentication failed!");
            return;
        }

        FinanceTracker tracker = new FinanceTracker();

        while (true) {
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. Set Financial Goal");
            System.out.println("5. View Summary");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double income = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter description: ");
                    String incomeDesc = scanner.nextLine();
                    tracker.addTransaction("income", income, incomeDesc);
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    double expense = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter description: ");
                    String expenseDesc = scanner.nextLine();
                    tracker.addTransaction("expense", expense, expenseDesc);
                    break;
                case 3:
                    tracker.viewTransactions();
                    break;
                case 4:
                    System.out.print("Enter goal amount: ");
                    double goal = scanner.nextDouble();
                    tracker.setGoal(goal);
                    break;
                case 5:
                    tracker.showSummary();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
