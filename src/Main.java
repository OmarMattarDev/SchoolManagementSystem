import java.util.*;

public class Main {

    public static void main(String[] args) {

        // =========================
        // Create School
        // =========================

        School school = new School();


        // =========================
        // Create Students
        // =========================

        Student s1 = new Student(
                1,
                "Omar",
                20,
                PersonStatus.ACTIVE,
                3.8,
                4
        );

        Student s2 = new Student(
                2,
                "Ali",
                21,
                PersonStatus.ACTIVE,
                2.7,
                3
        );

        Student s3 = new Student(
                3,
                "Ahmed",
                19,
                PersonStatus.SUSPENDED,
                1.8,
                2
        );

        Student s4 = new Student(
                4,
                "Mona",
                20,
                PersonStatus.ACTIVE,
                3.5,
                4
        );

        Student s5 = new Student(
                5,
                "Sara",
                22,
                PersonStatus.GRADUATED,
                3.9,
                4
        );


        // =========================
        // Add Courses
        // =========================

        s1.addCourse("Java");
        s1.addCourse("Database");
        s1.addCourse("Algorithms");

        s2.addCourse("Java");
        s2.addCourse("Database");

        s3.addCourse("C++");
        s3.addCourse("Data Structures");

        s4.addCourse("Java");
        s4.addCourse("Algorithms");

        s5.addCourse("Java");
        s5.addCourse("Spring Boot");
        s5.addCourse("Database");


        // =========================
        // Create Teachers
        // =========================

        Teacher t1 = new Teacher(
                101,
                "Mohamed",
                35,
                PersonStatus.ACTIVE,
                18000,
                "Java"
        );

        Teacher t2 = new Teacher(
                102,
                "Ahmed",
                42,
                PersonStatus.ACTIVE,
                22000,
                "Database"
        );

        Teacher t3 = new Teacher(
                103,
                "Mona",
                31,
                PersonStatus.SUSPENDED,
                15000,
                "Math"
        );

        Teacher t4 = new Teacher(
                104,
                "Sara",
                38,
                PersonStatus.ACTIVE,
                20000,
                "Java"
        );


        // =========================
        // Assign Classes
        // =========================

        t1.assignClass("CS-A");
        t1.assignClass("CS-B");

        t2.assignClass("CS-A");
        t2.assignClass("CS-C");

        t3.assignClass("CS-B");

        t4.assignClass("CS-A");
        t4.assignClass("CS-D");


        // =========================
        // Add People
        // =========================

        school.addPerson(s1);
        school.addPerson(s2);
        school.addPerson(s3);
        school.addPerson(s4);
        school.addPerson(s5);

        school.addPerson(t1);
        school.addPerson(t2);
        school.addPerson(t3);
        school.addPerson(t4);


        // =========================
        // Basic Information
        // =========================

        System.out.println("========================================");
        System.out.println("        SCHOOL MANAGEMENT SYSTEM");
        System.out.println("========================================");

        System.out.println("\nTotal Students : "
                + school.countStudents());

        System.out.println("Total Teachers : "
                + school.countTeachers());

        System.out.println("Active Persons : "
                + school.countActivePersons());


        // =========================
        // Display Persons
        // =========================

        System.out.println("\n========== ALL PERSONS ==========");

        school.getPersons()
                .forEach(System.out::println);


        // =========================
        // Find Person
        // =========================

        System.out.println("\n========== FIND PERSON ==========");

        System.out.println(
                school.findPerson(1)
        );


        // =========================
        // Sorting
        // =========================

        System.out.println("\n========== STUDENTS BY GPA ==========");

        school.sortStudentsByGPA()
                .forEach(student ->
                        System.out.println(
                                student.getName()
                                        + " -> GPA: "
                                        + student.getGpa()
                        )
                );


        System.out.println("\n========== STUDENTS BY NAME ==========");

        school.sortStudentsByName()
                .forEach(student ->
                        System.out.println(
                                student.getName()
                        )
                );


        System.out.println("\n========== TEACHERS BY SALARY ==========");

        school.sortTeachersBySalary()
                .forEach(teacher ->
                        System.out.println(
                                teacher.getName()
                                        + " -> Salary: "
                                        + teacher.getSalary()
                        )
                );


        // =========================
        // Top Students / Teachers
        // =========================

        System.out.println("\n========== TOP 3 STUDENTS ==========");

        school.top3Students()
                .forEach(student ->
                        System.out.println(
                                student.getName()
                                        + " -> "
                                        + student.getGpa()
                        )
                );


        System.out.println("\n========== TOP 5 HIGHEST SALARIES ==========");

        school.top5HighestSalary()
                .forEach(teacher ->
                        System.out.println(
                                teacher.getName()
                                        + " -> "
                                        + teacher.getSalary()
                        )
                );


        // =========================
        // Filtering
        // =========================

        System.out.println("\n========== ACTIVE STUDENTS ==========");

        school.getActiveStudents()
                .forEach(student ->
                        System.out.println(
                                student.getName()
                        )
                );


        System.out.println("\n========== STUDENTS ABOVE GPA 3.0 ==========");

        school.getStudentsAboveGPA(3.0)
                .forEach(student ->
                        System.out.println(
                                student.getName()
                                        + " -> "
                                        + student.getGpa()
                        )
                );


        System.out.println("\n========== LEVEL 4 STUDENTS ==========");

        school.getStudentsByLevel(4)
                .forEach(student ->
                        System.out.println(
                                student.getName()
                        )
                );


        // =========================
        // Streams + Statistics
        // =========================

        System.out.println("\n========== GPA STATISTICS ==========");

        System.out.println(
                school.gpaStatistics()
        );


        System.out.println("\nAverage GPA : "
                + school.averageGPA().orElse(0));

        System.out.println("Total GPA : "
                + school.totalGPA());


        System.out.println("\n========== SALARY STATISTICS ==========");

        System.out.println(
                school.salaryStatistics()
        );

        System.out.println("\nAverage Salary : "
                + school.averageSalary().orElse(0));

        System.out.println("Total Salary : "
                + school.totalSalary());


        // =========================
        // Min / Max + Optional
        // =========================

        System.out.println("\n========== BEST STUDENT ==========");

        school.getHighestGPAStudent()
                .ifPresent(student ->
                        System.out.println(
                                student.getName()
                                        + " -> "
                                        + student.getGpa()
                        )
                );


        System.out.println("\n========== LOWEST GPA STUDENT ==========");

        school.getLowestGPAStudent()
                .ifPresent(student ->
                        System.out.println(
                                student.getName()
                                        + " -> "
                                        + student.getGpa()
                        )
                );


        System.out.println("\n========== HIGHEST PAID TEACHER ==========");

        school.getHighestSalaryTeacher()
                .ifPresent(teacher ->
                        System.out.println(
                                teacher.getName()
                                        + " -> "
                                        + teacher.getSalary()
                        )
                );


        // =========================
        // Grouping
        // =========================

        System.out.println("\n========== STUDENTS BY LEVEL ==========");

        school.groupStudentsByLevel()
                .forEach((level, students) ->
                        System.out.println(
                                "Level " + level
                                        + " -> "
                                        + students
                        )
                );


        System.out.println("\n========== TEACHERS BY SUBJECT ==========");

        school.groupTeachersBySubject()
                .forEach((subject, teachers) ->
                        System.out.println(
                                subject
                                        + " -> "
                                        + teachers
                        )
                );


        // =========================
        // Counting
        // =========================

        System.out.println("\n========== STUDENTS COUNT BY LEVEL ==========");

        school.studentsCountByLevel()
                .forEach((level, count) ->
                        System.out.println(
                                "Level "
                                        + level
                                        + " -> "
                                        + count
                        )
                );


        System.out.println("\n========== TEACHERS COUNT BY SUBJECT ==========");

        school.teachersCountBySubject()
                .forEach((subject, count) ->
                        System.out.println(
                                subject
                                        + " -> "
                                        + count
                        )
                );


        // =========================
        // Average by Group
        // =========================

        System.out.println("\n========== AVERAGE GPA BY LEVEL ==========");

        school.averageGPAByLevel()
                .forEach((level, average) ->
                        System.out.println(
                                "Level "
                                        + level
                                        + " -> "
                                        + average
                        )
                );


        System.out.println("\n========== AVERAGE SALARY BY SUBJECT ==========");

        school.averageSalaryBySubject()
                .forEach((subject, average) ->
                        System.out.println(
                                subject
                                        + " -> "
                                        + average
                        )
                );


        // =========================
        // Partitioning
        // =========================

        System.out.println("\n========== PASSED STUDENTS ==========");

        Map<Boolean, List<Student>> passedStudents =
                school.partitionStudentsBySuccess();

        System.out.println("Passed : "
                + passedStudents.get(true));

        System.out.println("Failed : "
                + passedStudents.get(false));


        // =========================
        // Joining
        // =========================

        System.out.println("\n========== STUDENT NAMES ==========");

        System.out.println(
                school.studentNames()
        );


        System.out.println("\n========== TEACHER NAMES ==========");

        System.out.println(
                school.teacherNames()
        );


        // =========================
        // Maps
        // =========================

        System.out.println("\n========== TEACHER ID -> SUBJECT ==========");

        school.teacherIdSubjectMap()
                .forEach((id, subject) ->
                        System.out.println(
                                id
                                        + " -> "
                                        + subject
                        )
                );


        System.out.println("\n========== STUDENT ID -> NAME ==========");

        school.studentIdToName()
                .forEach((id, name) ->
                        System.out.println(
                                id
                                        + " -> "
                                        + name
                        )
                );


        // =========================
        // Courses
        // =========================

        System.out.println("\n========== ALL COURSES ==========");

        System.out.println(
                school.getAllCourses()
        );


        System.out.println("\n========== SORTED COURSES ==========");

        System.out.println(
                school.getCoursesSorted()
        );


        // =========================
        // Advanced Grouping
        // =========================

        System.out.println("\n========== STUDENT NAMES BY LEVEL ==========");

        school.studentsNamesByLevel()
                .forEach((level, names) ->
                        System.out.println(
                                "Level "
                                        + level
                                        + " -> "
                                        + names
                        )
                );


        System.out.println("\n========== COURSES BY LEVEL ==========");

        school.coursesByLevel()
                .forEach((level, courses) ->
                        System.out.println(
                                "Level "
                                        + level
                                        + " -> "
                                        + courses
                        )
                );


        // =========================
        // Matching
        // =========================

        System.out.println("\n========== MATCHING ==========");

        System.out.println(
                "Has Graduated Student : "
                        + school.hasGraduatedStudent()
        );

        System.out.println(
                "All Students Passed : "
                        + school.allStudentsPassed()
        );

        System.out.println(
                "Any Teacher Salary > 25000 : "
                        + school.anyTeacherHasSalaryAbove(25000)
        );

        System.out.println(
                "No Suspended Persons : "
                        + school.noneSuspended()
        );


        // =========================
        // Find First / Find Any
        // =========================

        System.out.println("\n========== FIND FIRST / ANY ==========");

        school.findFirstExcellentStudent()
                .ifPresent(student ->
                        System.out.println(
                                "Excellent Student : "
                                        + student.getName()
                        )
                );

        school.findFirstMathTeacher()
                .ifPresent(teacher ->
                        System.out.println(
                                "Math Teacher : "
                                        + teacher.getName()
                        )
                );

        school.findAnyActiveStudent()
                .ifPresent(student ->
                        System.out.println(
                                "Any Active Student : "
                                        + student.getName()
                        )
                );


        // =========================
        // Multi-Level Sorting
        // =========================

        System.out.println("\n========== GPA THEN NAME ==========");

        school.sortStudentsByGPAThenName()
                .forEach(student ->
                        System.out.println(
                                student.getName()
                                        + " -> "
                                        + student.getGpa()
                        )
                );


        System.out.println("\n========== SALARY THEN AGE ==========");

        school.sortTeachersBySalaryThenAge()
                .forEach(teacher ->
                        System.out.println(
                                teacher.getName()
                                        + " -> Salary: "
                                        + teacher.getSalary()
                                        + ", Age: "
                                        + teacher.getAge()
                        )
                );


        // =========================
        // Most Courses / Classes
        // =========================

        System.out.println("\n========== STUDENT WITH MOST COURSES ==========");

        school.studentWithMostCourses()
                .ifPresent(student ->
                        System.out.println(
                                student.getName()
                                        + " -> "
                                        + student.getCourses().size()
                                        + " courses"
                        )
                );


        System.out.println("\n========== TEACHER WITH MOST CLASSES ==========");

        school.teacherWithMostClasses()
                .ifPresent(teacher ->
                        System.out.println(
                                teacher.getName()
                                        + " -> "
                                        + teacher.getClasses().size()
                                        + " classes"
                        )
                );


        // =========================
        // Update Data
        // =========================

        System.out.println("\n========== UPDATE DATA ==========");

        s2.changeGPA(3.2);
        s3.changeStatus(PersonStatus.ACTIVE);
        t1.increaseSalary(2000);
        s1.increaseAge();

        System.out.println(
                "Updated Omar : "
                        + s1.getAge()
                        + " years old"
        );

        System.out.println(
                "Updated Ali GPA : "
                        + s2.getGpa()
        );

        System.out.println(
                "Updated Ahmed Status : "
                        + s3.getStatus()
        );

        System.out.println(
                "Updated Mohamed Salary : "
                        + t1.getSalary()
        );


        // =========================
        // Final Summary
        // =========================

        System.out.println("\n========================================");
        System.out.println("             FINAL SUMMARY");
        System.out.println("========================================");

        System.out.println(
                "Students : "
                        + school.countStudents()
        );

        System.out.println(
                "Teachers : "
                        + school.countTeachers()
        );

        System.out.println(
                "Active Persons : "
                        + school.countActivePersons()
        );

        System.out.println(
                "Total Salary : "
                        + school.totalSalary()
        );

        System.out.println(
                "Average GPA : "
                        + school.averageGPA().orElse(0)
        );

        System.out.println("\n========================================");
        System.out.println("       SCHOOL SYSTEM FINISHED");
        System.out.println("========================================");
    }
}