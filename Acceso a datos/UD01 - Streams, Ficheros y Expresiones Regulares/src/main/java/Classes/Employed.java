package Classes;

public class Employed {
    private String name;
    private String department;

    public Employed() {
    }

    public Employed(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}