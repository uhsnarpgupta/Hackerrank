import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestExperience {
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 6, 6, 8, 9};
        int target = 7;
        Map<String, Integer> employees = new HashMap<>();
        employees.put("ora1", 34);
        employees.put("ora2", 12);
        employees.put("ora3", 46);
        employees.put("ora4", 67);
        employees.put("ora5", 6);
        employees.put("ora6", 8);
        List<String> output = findClosest(employees, target);
        output.stream().forEach(System.out::println);
    }

    private static List<String> findClosest(Map<String, Integer> employees, int target) {
        List<String> closestEmployee = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        String emp = "";
        for (Map.Entry<String, Integer> entry : employees.entrySet()) {
            int diff = Math.abs(entry.getValue() - target);
            if (diff < min) {
                min = diff;
                emp = entry.getKey();
            }
        }
        if (!emp.isEmpty())
            closestEmployee.add(emp);
        for (Map.Entry<String, Integer> entry : employees.entrySet()) {
            if (entry.getKey() != emp && Math.abs(entry.getValue() - target) == min) {
                min = entry.getValue();
                emp = entry.getKey();
                closestEmployee.add(emp);
            }
        }
        return closestEmployee;
    }
}
