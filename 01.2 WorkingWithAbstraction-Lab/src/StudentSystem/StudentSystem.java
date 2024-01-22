package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] args = scanner.nextLine().split(" ");

        if (args[0].equals("Create")) {
            create(args);
        } else if (args[0].equals("Show")) {
            var name = args[1];
            if (show(name) != null) {
                System.out.println(show(name));
            }
        }
    }

    private void create(String[] args) {
        var name = args[1];
        var age = Integer.parseInt(args[2]);
        var grade = Double.parseDouble(args[3]);
        if (!repo.containsKey(name)) {
            var student = new Student(name, age, grade);
            repo.put(name, student);
        }
    }

    private String show(String name) {
        if (repo.containsKey(name)) {
            var student = repo.get(name);
            String view = String.format("%s is %s years old.", student.getName(), student.getAge());

            if (student.getGrade() >= 5.00) {
                view += " Excellent student.";
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                view += " Average student.";
            } else {
                view += " Very nice person.";
            }
            return view;
        }
        return null;
    }
}
