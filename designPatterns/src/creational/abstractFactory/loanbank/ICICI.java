package creational.abstractFactory.loanbank;

public class ICICI implements Bank {
    private final String BNAME;

    public ICICI() {
        this.BNAME = "ICICI NANK";
    }

    @Override
    public String getBankName() {
        return BNAME;
    }
}
