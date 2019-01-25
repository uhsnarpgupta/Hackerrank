package builder;

class Personale {
    //address
    public String streetAddress, city, postcode;

    // employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Personale{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

//builder facade
class PersonaleBuilder {
    protected Personale personale = new Personale();

    public AddressBuilder lives() {
        return new AddressBuilder(personale);
    }

    public JobBuilder works() {
        return new JobBuilder(personale);
    }

    public Personale build() {
        return personale;
    }
}

class AddressBuilder extends PersonaleBuilder {
    public AddressBuilder(Personale personale) {
        this.personale = personale;
    }

    public AddressBuilder at(String streetAddress) {
        personale.streetAddress = streetAddress;
        return this;
    }

    public AddressBuilder withPostCode(String postCode) {
        personale.postcode = postCode;
        return this;
    }

    public AddressBuilder in(String city) {
        personale.city = city;
        return this;
    }
}

class JobBuilder extends PersonaleBuilder {
    public JobBuilder(Personale personale) {
        this.personale = personale;
    }

    public JobBuilder at(String companyName) {
        personale.companyName = companyName;
        return this;
    }

    public JobBuilder asA(String position) {
        personale.position = position;
        return this;
    }

    public JobBuilder earning(int annualIncome) {
        personale.annualIncome = annualIncome;
        return this;
    }
}

public class Demo3 {
    public static void main(String[] args) {
        PersonaleBuilder pb = new PersonaleBuilder();
        Personale personale = pb
                .lives()
                .at("123 London Road")
                .in("London")
                .withPostCode("SW12BC")
                .works()
                .at("Dam")
                .asA("Engineer")
                .earning(12300)
                .build();

        System.out.println(personale);
    }
}
