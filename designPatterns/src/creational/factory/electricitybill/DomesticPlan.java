package creational.factory.electricitybill;

public class DomesticPlan extends Plan {
    @Override
    void getRate() {
        rate = 3.5;
    }
}
