// This class represents a bank account.
public class Account {

    // The name of the account holder.
    private String name;

    // The balance of the account.
    private double balance;

    // Constructs a new account with the given name and balance.
    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // Deposits the given amount into the account.
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdraws the given amount from the account.
    public void withdraw(double amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        balance -= amount;
    }

    // Returns the balance of the account.
    public double getBalance() {
        return balance;
    }

    // Returns a string representation of the account.
    @Override
    public String toString() {
        return String.format("Account(name=%s, balance=%s)", name, balance);
    }
}

// This class represents a savings account.
public class Saver extends Account {

    // The interest rate of the account.
    private double interestRate;

    // Constructs a new savings account with the given name, balance, and interest rate.
    public Saver(String name, double balance, double interestRate) {
        super(name, balance);
        this.interestRate = interestRate;
    }

    // Deposits the given amount into the account and earns interest on the deposit.
    @Override
    public void deposit(double amount) {
        super.deposit(amount);

        // Earn interest on the deposit
        balance += amount * interestRate;
    }
}

// This class represents a current account.
public class Current extends Account {

    // The overdraft limit of the account.
    private double overdraftLimit;

    // Constructs a new current account with the given name, balance, and overdraft limit.
    public Current(String name, double balance, double overdraftLimit) {
        super(name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Withdraws the given amount from the account.
    // If the balance is not enough, the overdraft limit is used.
    @Override
    public void withdraw(double amount) {
        if (balance < amount) {
            if (balance + overdraftLimit < amount) {
                throw new IllegalArgumentException("Overdraft limit exceeded");
            } else {
                balance -= amount;
            }
        }
    }
}

// This class represents a business account.
public class Business extends Account {

    // The credit limit of the account.
    private double creditLimit;

    // Constructs a new business account with the given name, balance, and credit limit.
    public Business(String name, double balance, double creditLimit) {
        super(name, balance);
        this.creditLimit = creditLimit;
    }

    // Withdraws the given amount from the account.
    // If the balance is not enough, the credit limit is used.
    @Override
    public void withdraw(double amount) {
        if (balance < amount) {
            if (balance + creditLimit < amount) {
                throw new IllegalArgumentException("Credit limit exceeded");
            } else {
                balance -= amount;
            }
        }
    }
}

// The main class.
public class Main {

    // The main method.
    public static void main(String[] args) {
        // Create a saver account.
        Saver save_account = new Saver("John Doe", 1000, 0.05);

        // Create a current account.
        Current current_account = new Current("Jane Doe", 5000, 500);

        // Create a business account.
        Business business_account = new Business("Jane Doe", 5000, 1000);

        // Print the accounts.
        System.out.println(save_account);
        System.out.println(current_account);
        System