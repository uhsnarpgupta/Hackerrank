package creational.abstractFactory.loanbank;

public class HDFC implements Bank {
    private final String BNAME;

    public HDFC() {
        this.BNAME = "HDFC NANK";
    }

    @Override
    public String getBankName() {
        return BNAME;
    }
}
