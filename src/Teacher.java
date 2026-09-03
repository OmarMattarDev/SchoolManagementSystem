import java.util.*;
public class Teacher extends Person{

    private double salary;

    private String subject;

    private final Set<String> classes;

    public Teacher(
            int id,
            String name,
            int age,
            PersonStatus status,
            double salary,
            String subject
    )
    {
        super(id, name, age, status);
        setSalary(salary);
        setSubject(subject);
        classes=new HashSet<>();
    }

    public double getSalary() {
        return salary;
    }

    public String getSubject() {
        return subject;
    }

    public Set<String> getClasses() {
        return new HashSet<>(classes);
    }

    private void setSalary(double salary) {
        if(salary<=0){
            throw new IllegalArgumentException("Salary must be greater than 0");
        }
        this.salary = salary;
    }

    private void setSubject(String subject) {
        if(subject == null || subject.isBlank()){
            throw new IllegalArgumentException("Subject cannot be null or blank");
        }
        this.subject = subject.trim().toUpperCase(Locale.ROOT);
    }

    public void increaseSalary(double salary){
        if(salary<=0){
            throw new IllegalArgumentException("Salary must be greater than 0");
        }
        setSalary(this.salary+salary);
    }

    public void decreaseSalary(double salary){
        if(salary<=0){
            throw new IllegalArgumentException("Salary must be greater than 0");
        }
        if(salary>=this.salary){
            throw new IllegalArgumentException("Salary must be less than current salary");
        }
        setSalary(this.salary-salary);
    }

    public boolean assignClass(String className){
        if(className == null || className.isBlank()){
            throw new IllegalArgumentException("Class cannot be null or blank");
        }
        return classes.add(className.trim().toUpperCase(Locale.ROOT));
    }

    public boolean removeClass(String className){
        if(className == null || className.isBlank()){
            throw new IllegalArgumentException("Class cannot be null or blank");
        }
        return classes.remove(className.trim().toUpperCase(Locale.ROOT));
    }


    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append("Salary : ").append(salary)
                .append("\nSubject : ").append(subject)
                .append("\nClasses : ").append(classes)
                .append("\n")
                .toString();
    }
}