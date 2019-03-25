package behavioural.command;

import java.util.List;

interface Command {
    void call();

    void undo();
}

public class BankAccount {
    private int balance;
    private int overdraftlimit = 0;

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", balance is now " + balance);
    }

    public boolean withdraw(int amount) {
        if (balance - amount >= overdraftlimit) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ", balance is now " + balance);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}

class BankAccountCommand implements Command {
    private BankAccount account;
    private boolean succeeded;
    private Action action;
    private int amount;

    public BankAccountCommand(BankAccount account, Action action, int amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public void call() {
        switch (action) {
            case DEPOSIT:
                succeeded = true;
                account.deposit(amount);
                break;
            case WITHDRAW:
                succeeded = account.withdraw(amount);
                break;
        }
    }

    @Override
    public void undo() {
        if (!succeeded) return;
        switch (action) {
            case DEPOSIT:
                account.withdraw(amount);
                break;
            case WITHDRAW:
                account.deposit(amount);
                break;
        }
    }

    public enum Action {
        DEPOSIT, WITHDRAW;
    }
}


class DemoBankAcc {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        System.out.println(ba);

        List<BankAccountCommand> commands = List.of(
                new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
                new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000));

        for (BankAccountCommand c : commands) {
            c.call();
            System.out.println(ba);
        }

        //Collections.reverse(commands);
        List<BankAccountCommand> commands2 = List.of(
                new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 1000),
                new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 100)
        );

        for (Command c : commands2) {
            c.undo();
            System.out.println(ba);
        }
    }
}