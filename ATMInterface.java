
    import java.util.Scanner;

    public class ATMInterface {
        private double balance;

        // Constructor to initialize account with a balance
        public ATMInterface(double initialBalance) {
            if (initialBalance >= 0) {
                this.balance = initialBalance;
            } else {
                System.out.println("Initial balance cannot be negative.");
                this.balance = 0;
            }
        }

        // Method to deposit money
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully deposited: $" + amount);
            } else {
                System.out.println("Deposit amount must be greater than zero.");
            }
        }

        // Method to withdraw money
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew: $" + amount);
            } else if (amount > balance) {
                System.out.println("Insufficient balance for this withdrawal.");
            } else {
                System.out.println("Withdrawal amount must be greater than zero.");
            }
        }

        // Method to check balance
        public double getBalance() {
            return balance;
        }

        // Method to display options and interact with the user
        public void start() {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\nWelcome to the ATM!");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Your current balance is: $" + getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);

            scanner.close();
        }

        public static void main(String[] args) {
            // Create an instance of the ATM with an initial balance of $1000
            ATMInterface atm = new ATMInterface(1000);

            // Start the ATM
            atm.start();
        }
    }


