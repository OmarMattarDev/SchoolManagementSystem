# 🏫 School Management System

A Java-based School Management System that demonstrates Object-Oriented Programming, Collections, Lambda Expressions, and the Stream API.

The project simulates a simple school management system where students and teachers can be managed, searched, filtered, sorted, grouped, and analyzed using Java Collections and Stream API operations.

## 🚀 Features

* Add and manage students and teachers
* Manage person statuses (`ACTIVE`, `SUSPENDED`, `GRADUATED`)
* Manage student courses
* Assign classes to teachers
* Update student GPA and academic level
* Increase student age
* Increase and decrease teacher salary
* Search for students and teachers
* Filter students and teachers by different criteria
* Sort students and teachers using different properties
* Get top students and highest-paid teachers
* Calculate GPA and salary statistics
* Group students by level
* Group teachers by subject
* Group people by status
* Count students by level
* Count teachers by subject
* Calculate average GPA by level
* Calculate average salary by subject
* Calculate total salary by subject
* Find students and teachers using `Optional`
* Perform matching operations using `anyMatch`, `allMatch`, and `noneMatch`
* Work with courses using `Set`
* Create different mappings using `Map`
* Process and analyze school data using Java Streams

## 🛠️ Technologies Used

* Java
* IntelliJ IDEA
* Git
* GitHub

## 🧠 Concepts Practiced

### Object-Oriented Programming

The project applies several OOP concepts, including:

* Classes and Objects
* Encapsulation
* Inheritance
* Abstraction
* Polymorphism
* Constructor Chaining
* Method Overriding

### Enum

The project uses an enum to represent the status of people in the school:

```java
PersonStatus {
    ACTIVE,
    SUSPENDED,
    GRADUATED
}
```

### Java Collections

The project uses different Java Collections depending on the required operation:

* `List`
* `ArrayList`
* `Set`
* `HashSet`
* `Map`
* `HashMap`

`HashSet` is used for managing student courses and teacher classes, while `HashMap` is used for managing students and teachers by their IDs.

### Lambda Expressions

Lambda expressions are used throughout the project for:

* Filtering
* Sorting
* Matching
* Finding elements
* Processing collections

### Comparator

The project uses `Comparator` for different sorting operations, including:

* Sorting students by GPA
* Sorting students by name
* Sorting students by age
* Sorting teachers by salary
* Sorting teachers by name
* Sorting teachers by salary and age
* Sorting students by GPA and name
* Sorting persons by status and name

### Stream API

The project makes extensive use of Java Streams for:

* Filtering
* Mapping
* Sorting
* Finding elements
* Matching elements
* Collecting
* Grouping
* Partitioning
* Joining
* Calculating averages
* Calculating totals
* Calculating statistics
* Processing nested collections using `flatMap`
* Advanced grouping using downstream collectors

### Collectors

The project practices several `Collectors` operations, including:

* `toList()`
* `toSet()`
* `toMap()`
* `joining()`
* `groupingBy()`
* `partitioningBy()`
* `mapping()`
* `filtering()`
* `flatMapping()`
* `counting()`
* `averagingDouble()`
* `summingDouble()`
* `maxBy()`

### Optional

`Optional` is used when searching for elements that may not exist, such as:

* Highest GPA student
* Lowest GPA student
* Highest salary teacher
* Lowest salary teacher
* First excellent student
* First Math teacher
* Any active student

### Summary Statistics

The project uses Java summary statistics to analyze school data:

* `IntSummaryStatistics`
* `DoubleSummaryStatistics`

These are used for GPA, salary, and age statistics.

## 📂 Project Structure

```text
SchoolManagementSystem/
│
├── src/
│   ├── Main.java
│   ├── Person.java
│   ├── PersonStatus.java
│   ├── School.java
│   ├── Student.java
│   └── Teacher.java
│
├── .gitignore
└── README.md
```

## ▶️ How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Make sure Java is installed and configured.
4. Open the `Main` class.
5. Run the `Main` method.

## 📌 Main Operations

The `School` class provides many operations for managing and analyzing school data, including:

### Management

* `addPerson()`
* `removePerson()`
* `findPerson()`

### Students

* `getActiveStudents()`
* `getStudentsAboveGPA()`
* `getStudentsByLevel()`
* `getStudentNames()`
* `getAllGPAs()`
* `getAllCourses()`
* `getCoursesSorted()`

### Teachers

* `getActiveTeachers()`
* `getTeachersWithSalaryAbove()`
* `getTeachersBySubject()`
* `getTeacherNames()`
* `getAllSalaries()`

### Sorting

* `sortStudentsByGPA()`
* `sortStudentsByName()`
* `sortStudentsByAge()`
* `sortStudentsByGPAThenName()`
* `sortTeachersBySalary()`
* `sortTeachersByName()`
* `sortTeachersBySalaryThenAge()`
* `sortPersonsById()`
* `sortPersonsByStatusThenName()`

### Top / Min / Max Operations

* `top3Students()`
* `top5HighestSalary()`
* `getHighestGPAStudent()`
* `getLowestGPAStudent()`
* `getHighestSalaryTeacher()`
* `getLowestSalaryTeacher()`
* `studentWithMostCourses()`
* `teacherWithMostClasses()`

### Statistics

* `averageGPA()`
* `averageSalary()`
* `totalGPA()`
* `totalSalary()`
* `gpaStatistics()`
* `salaryStatistics()`
* `studentsAgeStatistics()`
* `teachersAgeStatistics()`

### Grouping

* `groupStudentsByLevel()`
* `groupPersonsByStatus()`
* `groupTeachersBySubject()`
* `levelStudentNames()`
* `subjectTeacherNames()`
* `studentsCountByLevel()`
* `teachersCountBySubject()`

### Advanced Grouping & Aggregation

* `averageGPAByLevel()`
* `averageSalaryBySubject()`
* `totalSalaryBySubject()`
* `topStudentByLevel()`
* `highestSalaryBySubject()`
* `coursesByLevel()`
* `activeStudentsByLevel()`

### Partitioning

* `partitionStudentsBySuccess()`
* `partitionTeachersByHighSalary()`
* `countPassedStudents()`
* `passedStudentNames()`

### Matching & Finding

* `hasGraduatedStudent()`
* `allStudentsPassed()`
* `anyTeacherHasSalaryAbove()`
* `noneSuspended()`
* `findFirstExcellentStudent()`
* `findFirstMathTeacher()`
* `findAnyActiveStudent()`
* `findAnyTeacherBySubject()`

### Mapping & Joining

* `teacherIdSubjectMap()`
* `studentIdToName()`
* `studentNames()`
* `teacherNames()`

## 🎯 Project Goal

The main goal of this project is to apply and reinforce core Java and Stream API concepts by building a practical School Management System.

The project focuses on using OOP, Collections, Lambda Expressions, Comparators, Optional, and the Stream API to manage and process real-world school data.

## 🔮 Future Improvements

Possible future improvements include:

* Adding more school entities such as `Course`, `Department`, and `Classroom`
* Adding a database using JDBC
* Adding persistent data storage
* Adding a graphical user interface
* Adding user authentication
* Adding attendance management
* Adding an examination and grading system
* Connecting the project to a backend using Spring Boot

---

### 👨‍💻 Author

**Omar Mattar**

Java Developer in Progress 🚀
