package votingSystem;

import java.util.ArrayList;
import java.util.List;

public class Contestant extends Person {
    private List<Voter> voterList = new ArrayList<>();

    public Contestant(String name, int age, String contituency) {
        super(name, age, contituency);
    }

    public void vote(Voter voter) {
        this.voterList.add(voter);
    }

    public List<Voter> getVoterList() {
        return voterList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contestant) {
            Contestant c = (Contestant) obj;
            return this.getGovtId().equals(c.getGovtId());
        } else {
            return false;
        }
    }
}
