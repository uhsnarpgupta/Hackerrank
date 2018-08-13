import java.util.*;

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Estudent> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Estudent st : students) {
                System.out.println(st.getName());
            }
        }
    }
}

class EstudentComparator implements Comparator<Estudent> {
    @Override
    public int compare(Estudent o1, Estudent o2) {
        if (o1.getCgpa() != o2.getCgpa()) {
            return o1.getCgpa() < o2.getCgpa() ? 1 : -1;
        } else if (!o1.getName().equals(o2.getName())) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return o1.getId() > o2.getId() ? 1 : -1;
        }
    }
}

class Priorities {
    List<Estudent> list = new ArrayList<>();
    EstudentComparator comparator = new EstudentComparator();
    PriorityQueue<Estudent> priorityQueue = new PriorityQueue<>(comparator);

    List<Estudent> getStudents(List<String> events) {
        PriorityQueue<Estudent> student_queue = new PriorityQueue(
                Comparator.comparing(Estudent::getCgpa).reversed().thenComparing(Estudent::getName).thenComparing(Estudent::getId));
        for (String e : events) {
            Scanner in = new Scanner(e);
            String event = in.next();
            if (event.equals("ENTER")) {
                String name = in.next();
                float cgpa = in.nextFloat();
                int token = in.nextInt();

                Estudent student = new Estudent(name, cgpa, token);
                student_queue.add(student);
            } else if (event.equals("SERVED")) {
                Estudent first = student_queue.poll();
            }
            in.close();
        }
        Estudent first = student_queue.poll();
        if (first == null) {
            return list;
        } else {
            while (first != null) {

                list.add(first);
                first = student_queue.poll();

            }
            return list;
        }


        /*events.forEach(event -> {
            String[] e = event.split(" ");
            String eve = e[0];
            if (eve.equals("ENTER")) {
                Estudent stud = new Estudent(e[1], Double.parseDouble(e[2]), Integer.parseInt(e[3]));
                list.add(stud);
                priorityQueue.add(stud);
            } else if (eve.equals("SERVED")) {
                priorityQueue.remove();
            }
        });
        list.clear();
        list.addAll(priorityQueue);
        return list;*/
    }
}

class Estudent {
    private int id;
    private String name;
    private double cgpa;

    public Estudent(String name, double cgpa, int id) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}
