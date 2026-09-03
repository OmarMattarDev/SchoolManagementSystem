import java.util.*;
public class Student extends Person{

    private double gpa;

    private int level;

    private final Set<String> courses;

    public Student(
            int id,
            String name,
            int age,
            PersonStatus status,
            double gpa,
            int level
    )
    {
        super(id, name, age, status);
        setGpa(gpa);
        setLevel(level);
        courses=new HashSet<>();
    }

    public double getGpa() {
        return gpa;
    }

    public int getLevel() {
        return level;
    }

    public Set<String> getCourses() {
        return new HashSet<>(courses);
    }

    private void setGpa(double gpa) {
        if(gpa<0||gpa>4){
            throw new IllegalArgumentException("GPA must be between 0 and 4");
        }
        this.gpa = gpa;
    }

    private void setLevel(int level) {
        if(level<1||level>4){
            throw new IllegalArgumentException("Level must be between 1 and 4");
        }
        this.level = level;
    }

    public void changeGPA(double gpa){
        setGpa(gpa);
    }

    public void increaseLevel(){
        setLevel(level+1);
    }

    public boolean addCourse(String course){
        if(course == null || course.isBlank()){
            throw new IllegalArgumentException("Course cannot be null or blank");
        }
        return courses.add(course.trim().toUpperCase(Locale.ROOT));
    }

    public boolean removeCourse(String course){
        if (course == null || course.isBlank()) {
            throw new IllegalArgumentException("Course cannot be null or blank");
        }
        return courses.remove(course.trim().toUpperCase(Locale.ROOT));
    }


    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append("GPA : ").append(gpa)
                .append("\nLevel : ").append(level)
                .append("\nCourses : ").append(courses)
                .append("\n")
                .toString();
    }
}