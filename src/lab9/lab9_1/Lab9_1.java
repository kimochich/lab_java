package lab9.lab9_1;

class Person {
    private int id;
    private String name;
    private int age;
    private String address;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

public class Lab9_1 {


    public static void main(String[] args) {
        Person person = new Person();
        person.setId(1001);
        person.setName("Quynh");
        person.setAge(24);
        person.setAddress("Ha Noi");
        System.out.println("Id: " + person.getId());
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Address: " + person.getAddress());
    }
}
