package creational.abstractFactory.loanbank;

public class BusinessLoan extends Loan {
    @Override
    void getInterestRate(double rate) {
        this.rate = rate;
    }
}
