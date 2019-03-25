package votingSystem;

import java.util.*;

public class Evm {
    static Set<Contestant> contestants = new HashSet<>();
    static Set<Voter> voters = new HashSet<>();
    private static Map<Contestant, List<Voter>> votingMap = new HashMap<>();

    static void addContestants() {
        Contestant modi = new Contestant("Modi", 62, "Varanasi");
        Contestant rahul = new Contestant("Rahul", 42, "Amethi");
        Contestant didi = new Contestant("Didi", 72, "Kolkata");
        Contestant chachi = new Contestant("Chachi", 55, "Kolkata");
        Contestant amit = new Contestant("Amit Shah", 44, "Amethi");
        Contestant ram = new Contestant("Ram", 50, "Varanasi");

        contestants.add(modi);
        contestants.add(rahul);
        contestants.add(didi);
        contestants.add(amit);
        contestants.add(chachi);
        contestants.add(ram);
    }

    static void addVoters() {
        Voter voter1 = new Voter("A", 25, "Varanasi");
        Voter voter2 = new Voter("B", 22, "Varanasi");
        Voter voter3 = new Voter("C", 30, "Varanasi");
        Voter voter4 = new Voter("D", 19, "Varanasi");

        Voter voter5 = new Voter("E", 25, "Kolkata");
        Voter voter6 = new Voter("F", 22, "Kolkata");
        Voter voter7 = new Voter("G", 30, "Amethi");
        Voter voter8 = new Voter("H", 19, "Amethi");

        voters.add(voter1);
        voters.add(voter2);
        voters.add(voter3);
        voters.add(voter4);
        voters.add(voter5);
        voters.add(voter6);
        voters.add(voter7);
        voters.add(voter8);
    }

    static void vote(Contestant contestant, Voter voter) {
        contestant.vote(voter);
        //votingMap.put(contestant, contestant.getVoterList());
    }

    static void polling() {
        varanasiVoting();
        amethiVoting();
        kolkataVoting();
    }

    static void varanasiVoting() {
        List<Contestant> varanasiContestants = new ArrayList<>();
        contestants.forEach(contestant -> {
            if (contestant.getContituency().equals("Varanasi")) {
                varanasiContestants.add(contestant);
            }
        });
        voters.stream().forEach(voter -> {
            if (voter.getContituency().equals("Varanasi")) {
                Contestant cont = null;
                if (voter.getAge() % 2 == 0)
                    cont = varanasiContestants.get(0);
                else {
                    cont = varanasiContestants.get(1);
                }
                cont.vote(voter);
                votingMap.put(cont, cont.getVoterList());
            }
        });
    }

    static void amethiVoting() {
        List<Contestant> amethiContestants = new ArrayList<>();
        contestants.forEach(contestant -> {
            if (contestant.getContituency().equals("Amethi")) {
                amethiContestants.add(contestant);
            }
        });
        voters.stream().forEach(voter -> {
            if (voter.getContituency().equals("Amethi")) {
                Contestant cont = null;
                if (voter.getAge() % 2 == 0)
                    cont = amethiContestants.get(0);
                else {
                    cont = amethiContestants.get(1);
                }
                cont.vote(voter);
                votingMap.put(cont, cont.getVoterList());
            }
        });
    }

    static void kolkataVoting() {
        List<Contestant> kolkataContestants = new ArrayList<>();
        contestants.forEach(contestant -> {
            if (contestant.getContituency().equals("Kolkata")) {
                kolkataContestants.add(contestant);
            }
        });
        voters.stream().forEach(voter -> {
            if (voter.getContituency().equals("Kolkata")) {
                Contestant cont = null;
                if (voter.getAge() % 2 == 0)
                    cont = kolkataContestants.get(0);
                else {
                    cont = kolkataContestants.get(1);
                }
                cont.vote(voter);
                votingMap.put(cont, cont.getVoterList());
            }
        });
    }

    public static void main(String[] args) {
        Evm evm = new Evm();
        Evm.addContestants();
        Evm.addVoters();
        evm.polling();
        System.out.println(evm.getWinner("Varanasi"));

        evm.getVoters("Modi").forEach(System.out::println);
    }

    private String getWinner(String constituency) {
        List<Contestant> presentContestants = new ArrayList<>();
        votingMap.forEach((k, v) -> {
            if (k.getContituency().equalsIgnoreCase(constituency)) {
                presentContestants.add(k);
            }
        });
        int max = 0;
        Contestant winner = null;
        for (Contestant contestant : presentContestants) {
            if (contestant.getVoterList().size() > max) {
                max = contestant.getVoterList().size();
                winner = contestant;
            } else if (contestant.getVoterList().size() == max) {
                max = 0;
            }
        }
        if (max > 0) {
            return winner.getName();
        }
        return "Your constituency failed to decide a winner";
    }

    private List<Voter> getVoters(String contestantName) {
        List<Voter> voterList = new ArrayList<>();
        votingMap.forEach((k, v) -> {
            if (k.getName().equalsIgnoreCase(contestantName)) {
                voterList.addAll(k.getVoterList());
            }
        });
        return voterList;
    }
}
