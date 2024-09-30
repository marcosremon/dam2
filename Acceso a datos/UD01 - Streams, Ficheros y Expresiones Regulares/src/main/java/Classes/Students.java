package Classes;

public class Students {
    int id;
    String dni;
    String name;
    String lastName;
    String curse;
    double nota;
    int age;

    public Students() {
    }

    public Students(int id, String dni, String name, String lastName, String curse, double nota, int age) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.curse = curse;
        this.nota = nota;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCurse() {
        return curse;
    }

    public void setCurse(String curse) {
        this.curse = curse;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", curse='" + curse + '\'' +
                ", nota=" + nota +
                ", age=" + age +
                '}';
    }
}