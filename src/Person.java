public abstract class Person {

    private String name;

    private int age,id;

    private PersonStatus status;

    public Person(
            int id,
            String name,
            int age,
            PersonStatus status
    )
    {
        setId(id);
        setName(name);
        setAge(age);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public PersonStatus getStatus() {
        return status;
    }

    private void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name.trim();
    }

    private void setAge(int age) {
        if(age<=0){
            throw new IllegalArgumentException("Age must be greater than 0");
        }
        this.age=age;
    }

    private void setId(int id) {
        if(id<=0){
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        this.id = id;
    }

    private void setStatus(PersonStatus status) {
        if(status==null){
            throw new IllegalArgumentException("Status cannot be null");
        }
        this.status = status;
    }

    public void changeStatus(PersonStatus status){
        setStatus(status);
    }

    public void increaseAge(){
        setAge(age+1);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("\nId : ").append(id)
                .append("\nName : ").append(name)
                .append("\nAge : ").append(age)
                .append("\nStatus : ").append(status)
                .append("\n")
                .toString();
    }
}