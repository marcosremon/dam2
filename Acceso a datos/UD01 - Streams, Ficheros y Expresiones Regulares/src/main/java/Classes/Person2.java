package Classes;

public class Person2 {
    int id;
    String name;
    String secondName;
    String course;
    int notes;
    int age;

    public Person2() {
    }

    public Person2(int id, String name, String secondName, String course, int notes, int age) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.course = course;
        this.notes = notes;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getNotes() {
        return notes;
    }

    public void setNotes(int notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", course='" + course + '\'' +
                ", notes=" + notes +
                ", age=" + age +
                '}';
    }
}