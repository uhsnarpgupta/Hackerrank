package creational.factory.electricitybill;

public class CommercialPlan extends Plan {
    @Override
    void getRate() {
        rate = 7.5;
    }
}
