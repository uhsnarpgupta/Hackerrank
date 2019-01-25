package solid.srp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
SOLID DESIGN PRINICPLES
Single Responsibility Principle :
- A class should have only one reason to change
- Separation of concerns -: different classes handling different, independent tasks/problems
 */
class Journal {
    private static int count = 0;
    private final List<String> entries = new ArrayList<>();

    public void addEntry(String text) {
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    /*public void save(String filename) throws FileNotFoundException{
        try(PrintStream out = new PrintStream(filename)){
            out.println(toString());
        }
    }

    public void load(String filename){}
    public void load(URL url){}*/

}

class Persistence {
    public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
        if (overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }
    }

    public void loadFile(String filename) {
    }

    public void loadFile(URL url) {
    }
}

public class Demo {
    public static void main(String[] args) throws Exception {
        Journal j = new Journal();
        j.addEntry("Journal Start");
        j.addEntry("Journal End");
        System.out.println(j);

        Persistence p = new Persistence();
        String filename = "C:\\Users\\pragupta14\\IdeaProjects\\Hackerrank\\designPatterns\\journal.txt";
        p.saveToFile(j, filename, true);

        Runtime.getRuntime().exec("notepad.exe " + filename);
    }
}
