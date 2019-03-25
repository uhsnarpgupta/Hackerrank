package votingSystem;

import java.util.UUID;

public class Person {
    private String name;
    private int age;
    private String govtId;
    private String contituency;

    public Person(String name, int age, String contituency) {
        this.name = name;
        this.age = age;
        this.govtId = uniqueIdGenerator();
        this.contituency = contituency;
    }

    private String uniqueIdGenerator() {
        return UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGovtId() {
        return govtId;
    }

    public void setGovtId(String govtId) {
        this.govtId = govtId;
    }

    public String getContituency() {
        return contituency;
    }

    public void setContituency(String contituency) {
        this.contituency = contituency;
    }

    @Override
    public String toString() {
        return name;
    }
}
