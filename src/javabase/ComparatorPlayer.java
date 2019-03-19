package javabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ComparatorPlayer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
        ArrayList<Integer> list= new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(0,3);
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.score != o2.score) {
            return o2.score - o1.score;
        } else {
            return o1.name.compareTo(o2.name);
        }
    }
}