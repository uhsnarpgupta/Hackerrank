import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingComparator {
    public static void main(String[] args) {

        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Ram", 75));
        playerList.add(new Player("Lam", 75));
        playerList.add(new Player("Shyam", 90));
        playerList.add(new Player("Aam", 45));
        playerList.add(new Player("Balm", 56));

        Collections.sort(playerList, new Checker());

        playerList.forEach(System.out::println);

    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        if (p1.getScore() != p2.getScore()) {
            return p2.getScore() - p1.getScore();
        } else {
            return p1.getName().compareTo(p2.getName());
        }
    }
}

class Player {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }
}
