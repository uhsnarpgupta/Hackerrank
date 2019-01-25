package builder;

/*
Fluent interface to propagate acrooss inheritance hierarchies, then we need recursive generics definition,
so instead of person builder you need a PersonBuilder that takes a type argument SELF which extends PersonBuilder
and for every kind of inheriter you stick that inheriter as a type argument of PersonBuilder thereby propagating this
idea of always returning a type reference to the most derived type that you're working with
 */
class Person {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    protected SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

public class Demo2 {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person myName = pb.withName("MyName").build();

        System.out.println(myName);

        EmployeeBuilder eb = new EmployeeBuilder();

        Person xName = eb.withName("xName")
                .worksAt("Developer")
                .build();

        System.out.println(xName);
    }
}
