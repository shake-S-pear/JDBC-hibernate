package HWorks.Lesson2.extraTask.entity;

public class Employee {

    private int idEmployee;
    private String name;
    private String telephone;

    public Employee(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public int getIdEmployee() { return idEmployee; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}