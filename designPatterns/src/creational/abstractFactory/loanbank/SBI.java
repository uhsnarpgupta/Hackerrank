package creational.abstractFactory.loanbank;

public class SBI implements Bank {
    private final String BNAME;

    public SBI() {
        this.BNAME = "SBI NANK";
    }

    @Override
    public String getBankName() {
        return BNAME;
    }
}
