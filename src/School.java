import java.util.*;
import java.util.stream.*;

public class School {

    private final List<Person> persons;

    private final Map<Integer, Student> students;

    private final Map<Integer, Teacher> teachers;

    public School(){
        persons=new ArrayList<>();
        students=new HashMap<>();
        teachers=new HashMap<>();
    }

    public List<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    public Map<Integer, Student> getStudents() {
        return new HashMap<>(students);
    }

    public Map<Integer, Teacher> getTeachers() {
        return new HashMap<>(teachers);
    }

    public void addPerson(Person person){
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        if
        (
                students.containsKey(person.getId())
                ||
                        teachers.containsKey(person.getId())
        )
        {
            throw new IllegalArgumentException("ID already exists");
        }
        persons.add(person);
        if(person instanceof Student student){
            students.put(student.getId(), student);
        }
        else if(person instanceof Teacher teacher){
            teachers.put(teacher.getId(), teacher);
        }
    }

    public boolean removePerson(int id){
        boolean removedStudent=students.remove(id)!=null;
        boolean removedTeacher=teachers.remove(id)!=null;
        if(removedStudent||removedTeacher){
            persons
                    .removeIf(
                    person ->
                            person.getId()==id
            );
            return true;
        }
        return false;
    }

    public Person findPerson(int id){
        Student student=students.get(id);
        if(student!=null){
            return student;
        }
        Teacher teacher=teachers.get(id);
        if(teacher!=null){
            return teacher;
        }
        throw new IllegalArgumentException("No student or teacher has this ID");
    }

    public List<Student> sortStudentsByGPA(){
        return students.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Student::getGpa
                        )
                                .reversed()
                )
                .toList();
    }

    public List<Teacher> sortTeachersBySalary(){
        return teachers.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Teacher::getSalary
                        )
                                .reversed()
                )
                .toList();
    }

    public Map<PersonStatus,Long> countStatus(){
        return persons
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getStatus,
                                Collectors.counting()
                        )
                );
    }

    public List<Student> getActiveStudents(){
        return students.values()
                .stream()
                .filter(
                        student ->
                                student.getStatus()==PersonStatus.ACTIVE
                )
                .toList();
    }

    public List<Teacher> getActiveTeachers(){
        return teachers.values()
                .stream()
                .filter(
                        teacher ->
                                teacher.getStatus()==PersonStatus.ACTIVE
                )
                .toList();
    }

    public List<String> getSubjects(){
        return teachers.values()
                .stream()
                .map(
                        Teacher::getSubject
                )
                .toList();
    }

    public List<Student> getStudentsAboveGPA(double gpa){
        if(gpa<0||gpa>4){
            throw new IllegalArgumentException("GPA must be between 0 and 4");
        }
        return students.values()
                .stream()
                .filter(
                        student ->
                                student.getGpa()>gpa
                )
                .toList();
    }

    public List<Student> getStudentsByLevel(int level){
        if(level<1||level>4){
            throw new IllegalArgumentException("Level must be between 1 and 4");
        }
        return students.values()
                .stream()
                .filter(
                        student ->
                                student.getLevel()==level
                )
                .toList();
    }

    public List<Teacher> getTeachersWithSalaryAbove(double salary){
        if(salary<=0){
            throw new IllegalArgumentException("Salary must be positive");
        }
        return teachers.values()
                .stream()
                .filter(
                        teacher ->
                                teacher.getSalary()>salary
                )
                .toList();
    }

    public List<Teacher> getTeachersBySubject(String subject){
        if(subject == null || subject.isBlank()){
            throw new IllegalArgumentException("Subject cannot be null or blank");
        }
        return teachers.values()
                .stream()
                .filter(
                        teacher ->
                                teacher.getSubject().equals(subject.trim().toUpperCase(Locale.ROOT))
                )
                .toList();
    }

    public List<String> getStudentNames(){
        return students.values()
                .stream()
                .map(
                        Student::getName
                )
                .toList();
    }

    public List<String> getTeacherNames(){
        return teachers.values()
                .stream()
                .map(
                        Teacher::getName
                )
                .toList();
    }

    public List<Double> getAllGPAs(){
        return students.values()
                .stream()
                .map(
                        Student::getGpa
                )
                .toList();
    }

    public List<Double> getAllSalaries(){
        return teachers.values()
                .stream()
                .map(
                        Teacher::getSalary
                )
                .toList();
    }

    public Set<String> getAllCourses(){
        return students.values()
                .stream()
                .map(
                        Student::getCourses
                )
                .flatMap(
                        Set::stream
                )
                .collect(
                        Collectors.toSet()
                );
    }

    public List<String> getCoursesSorted(){
        return students.values()
                .stream()
                .map(
                        Student::getCourses
                )
                .flatMap(
                        Set::stream
                )
                .sorted()
                .toList();
    }

    public List<Integer> getAllLevels(){
        return students.values()
                .stream()
                .map(
                        Student::getLevel
                )
                .distinct()
                .toList();
    }

    public List<Student> sortStudentsByAge(){
        return students.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Student::getAge
                        )
                )
                .toList();
    }

    public List<Student> sortStudentsByName(){
        return students.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Student::getName
                        )
                )
                .toList();
    }

    public List<Teacher> sortTeachersByName(){
        return teachers.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Teacher::getName
                        )
                )
                .toList();
    }

    public List<Person> sortPersonsById(){
        return persons
                .stream()
                .sorted(
                        Comparator.comparing(
                                Person::getId
                        )
                )
                .toList();
    }

    public List<Student> top3Students(){
        return students.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Student::getGpa
                        )
                                .reversed()
                )
                .limit(3)
                .toList();
    }

    public List<Teacher> top5HighestSalary(){
        return teachers.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Teacher::getSalary
                        )
                                .reversed()
                )
                .limit(5)
                .toList();
    }

    public List<Student> skipTop3Students(){
        return students.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                        Student::getGpa
                                )
                                .reversed()
                )
                .skip(3)
                .toList();
    }

    public int countStudents(){
        return students.size();
    }

    public int countTeachers(){
        return teachers.size();
    }

    public long countActivePersons(){
        return persons
                .stream()
                .filter(
                        person ->
                                person.getStatus()==PersonStatus.ACTIVE
                )
                .count();
    }

    public Optional<Student> getLowestGPAStudent(){
        return students.values()
                .stream()
                .min(
                        Comparator.comparing(
                                Student::getGpa
                        )
                );
    }

    public Optional<Student> getHighestGPAStudent(){
        return students.values()
                .stream()
                .max(
                        Comparator.comparing(
                                Student::getGpa
                        )
                );
    }

    public Optional<Teacher> getHighestSalaryTeacher(){
        return teachers.values()
                .stream()
                .max(
                        Comparator.comparing(
                                Teacher::getSalary
                        )
                );
    }

    public Optional<Teacher> getLowestSalaryTeacher(){
        return teachers.values()
                .stream()
                .min(
                        Comparator.comparing(
                                Teacher::getSalary
                        )
                );
    }

    public OptionalDouble averageGPA(){
        return students.values()
                .stream()
                .mapToDouble(
                        Student::getGpa
                )
                .average();
    }

    public OptionalDouble averageSalary(){
        return teachers.values()
                .stream()
                .mapToDouble(
                        Teacher::getSalary
                )
                .average();
    }

    public double totalSalary(){
        return teachers.values()
                .stream()
                .map(
                        Teacher::getSalary
                )
                .reduce(
                        0.0,
                        Double::sum
                );
    }

    public DoubleSummaryStatistics salaryStatistics(){
        return teachers.values()
                .stream()
                .collect(
                        Collectors.summarizingDouble(
                                Teacher::getSalary
                        )
                );
    }

    public DoubleSummaryStatistics gpaStatistics(){
        return students.values()
                .stream()
                .collect(
                        Collectors.summarizingDouble(
                                Student::getGpa
                        )
                );
    }

    public Map<Integer,List<Student>> groupStudentsByLevel(){
        return students.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getLevel
                        )
                );
    }

    public Map<PersonStatus,List<Person>> groupPersonsByStatus(){
        return persons
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getStatus
                        )
                );
    }

    public Map<String,List<Teacher>> groupTeachersBySubject(){
        return teachers.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Teacher::getSubject
                        )
                );
    }

    public Map<Boolean,List<Student>> partitionStudentsBySuccess(){
        return students.values()
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                student ->
                                        student.getGpa()>=2
                        )
                );
    }

    public Map<Boolean,List<Teacher>> partitionTeachersByHighSalary(){
        return teachers.values()
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                teacher ->
                                        teacher.getSalary()>=15000
                        )
                );
    }

    public String studentNames(){
        return students.values()
                .stream()
                .map(
                        Student::getName
                )
                .collect(
                        Collectors.joining(", ")
                );
    }

    public String teacherNames(){
        return teachers.values()
                .stream()
                .map(
                        Teacher::getName
                )
                .collect(
                        Collectors.joining(", ")
                );
    }

    public Map<Integer,String> teacherIdSubjectMap(){
        return teachers.values()
                .stream()
                .collect(
                        Collectors.toMap(
                                Teacher::getId,
                                Teacher::getSubject
                        )
                );
    }

    public boolean hasGraduatedStudent(){
        return students.values()
                .stream()
                .anyMatch(
                        student ->
                                student.getStatus()==PersonStatus.GRADUATED
                );
    }

    public boolean allStudentsPassed(){
        return students.values()
                .stream()
                .allMatch(
                        student ->
                                student.getGpa()>=2
                );
    }

    public boolean anyTeacherHasSalaryAbove(double salary){
        if(salary<=0){
            throw new IllegalArgumentException("Salary must be positive");
        }
        return teachers.values()
                .stream()
                .anyMatch(
                        teacher ->
                                teacher.getSalary()>salary
                );
    }

    public boolean noneSuspended(){
        return persons
                .stream()
                .noneMatch(
                        person ->
                                person.getStatus()==PersonStatus.SUSPENDED
                );
    }

    public Optional<Student> findFirstExcellentStudent(){
        return students.values()
                .stream()
                .filter(
                        student ->
                                student.getGpa()>3.5
                )
                .findFirst();
    }

    public Optional<Teacher> findFirstMathTeacher(){
        return teachers.values()
                .stream()
                .filter(
                        teacher ->
                                teacher.getSubject().equalsIgnoreCase("Math")
                )
                .findFirst();
    }

    public double totalGPA(){
        return students.values()
                .stream()
                .map(
                        Student::getGpa
                )
                .reduce(
                        0.0,
                        Double::sum
                );
    }

    public Map<Integer,String> studentIdToName(){
        return students.values()
                .stream()
                .collect(
                        Collectors.toMap(
                                Student::getId,
                                Student::getName,
                                (a,b)->a
                        )
                );
    }

    public Optional<Student> findAnyActiveStudent(){
        return students.values()
                .stream()
                .filter(
                        student ->
                                student.getStatus()==PersonStatus.ACTIVE
                )
                .findAny();
    }

    public Optional<Teacher> findAnyTeacherBySubject(String subject){
        if(subject == null || subject.isBlank()){
            throw new IllegalArgumentException("Subject cannot be null or blank");
        }
        return teachers.values()
                .stream()
                .filter(
                        teacher ->
                                teacher.getSubject().equals(subject.trim().toUpperCase(Locale.ROOT))
                )
                .findAny();
    }

    public List<Student> sortStudentsByGPAThenName(){
        return students.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Student::getGpa
                        )
                                .reversed()
                                .thenComparing(
                                        Student::getName
                                )
                )
                .toList();
    }

    public List<Teacher> sortTeachersBySalaryThenAge(){
        return teachers.values()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Teacher::getSalary
                        )
                                .reversed()
                                .thenComparing(
                                        Teacher::getAge
                                )
                )
                .toList();
    }

    public List<Person> sortPersonsByStatusThenName(){
        return persons
                .stream()
                .sorted(
                        Comparator.comparing(
                                Person::getStatus
                        )
                                .thenComparing(
                                        Person::getName
                                )
                )
                .toList();
    }

    public Map<Integer,List<String>> levelStudentNames(){
        return students.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getLevel,
                                Collectors.mapping(
                                        Student::getName,
                                        Collectors.toList()
                                )
                        )
                );
    }

    public Map<String,List<String>> subjectTeacherNames(){
        return teachers.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Teacher::getSubject,
                                Collectors.mapping(
                                        Teacher::getName,
                                        Collectors.toList()
                                )
                        )
                );
    }

    public Map<Integer,Long> studentsCountByLevel(){
        return students.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getLevel,
                                Collectors.counting()
                        )
                );
    }

    public Map<String,Long> teachersCountBySubject(){
        return teachers.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Teacher::getSubject,
                                Collectors.counting()
                        )
                );
    }

    public Map<Integer,Double> averageGPAByLevel(){
        return students.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getLevel,
                                Collectors.averagingDouble(
                                        Student::getGpa
                                )
                        )
                );
    }

    public Map<String,Double> averageSalaryBySubject(){
        return teachers.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Teacher::getSubject,
                                Collectors.averagingDouble(
                                        Teacher::getSalary
                                )
                        )
                );
    }

    public Map<String,Double> totalSalaryBySubject(){
        return teachers.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Teacher::getSubject,
                                Collectors.summingDouble(
                                        Teacher::getSalary
                                )
                        )
                );
    }

    public Map<Integer,Optional<Student>> topStudentByLevel(){
        return students.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getLevel,
                                Collectors.maxBy(
                                        Comparator.comparing(
                                                Student::getGpa
                                        )
                                )
                        )
                );
    }

    public Map<String,Optional<Teacher>> highestSalaryBySubject(){
        return teachers.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Teacher::getSubject,
                                Collectors.maxBy(
                                        Comparator.comparing(
                                                Teacher::getSalary
                                        )
                                )
                        )
                );
    }

    public Map<Boolean,Long> countPassedStudents(){
        return students.values()
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                student ->
                                        student.getGpa()>=2,
                                Collectors.counting()
                        )
                );
    }

    public Map<Boolean,List<String>> passedStudentNames(){
        return students.values()
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                student ->
                                        student.getGpa()>=2,
                                Collectors.mapping(
                                        Student::getName,
                                        Collectors.toList()
                                )
                        )
                );
    }

    public Map<Integer,String> studentsNamesByLevel(){
        return students.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getLevel,
                                Collectors.mapping(
                                        Student::getName,
                                        Collectors.joining(", ")
                                )
                        )
                );
    }

    public Map<Integer,Set<String>> coursesByLevel(){
        return students.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getLevel,
                                Collectors.flatMapping(
                                        student ->
                                                student.getCourses().stream(),
                                        Collectors.toSet()
                                )
                        )
                );
    }

    public Map<Integer,List<Student>> activeStudentsByLevel(){
        return students.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getLevel,
                                Collectors.filtering(
                                        student ->
                                                student.getStatus()==PersonStatus.ACTIVE,
                                        Collectors.toList()
                                )
                        )
                );
    }

    public IntSummaryStatistics studentsAgeStatistics(){
        return students.values()
                .stream()
                .collect(
                        Collectors.summarizingInt(
                                Student::getAge
                        )
                );
    }

    public IntSummaryStatistics teachersAgeStatistics(){
        return teachers.values()
                .stream()
                .collect(
                        Collectors.summarizingInt(
                                Teacher::getAge
                        )
                );
    }

    public Optional<Student> studentWithMostCourses(){
        return students.values()
                .stream()
                .max(
                        Comparator.comparing(
                                student ->
                                        student.getCourses().size()
                        )
                );
    }

    public Optional<Teacher> teacherWithMostClasses(){
        return teachers.values()
                .stream()
                .max(
                        Comparator.comparing(
                                teacher ->
                                        teacher.getClasses().size()
                        )
                );
    }
}