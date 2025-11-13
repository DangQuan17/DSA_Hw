import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }

}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // 1.CGPA
        int cgpaCompare = Double.compare(s2.getCgpa(), s1.getCgpa());
        if (cgpaCompare != 0) {
            return cgpaCompare;
        }

        // 2.Tên
        int nameCompare = s1.getFname().compareTo(s2.getFname());
        if (nameCompare != 0) {
            return nameCompare;
        }

        return Integer.compare(s1.getId(), s2.getId());
    }
}

public class JavaSort{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

    // sắp xếp danh sách theo thứ tự đối tượng.
        Collections.sort(studentList, new StudentComparator());

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
