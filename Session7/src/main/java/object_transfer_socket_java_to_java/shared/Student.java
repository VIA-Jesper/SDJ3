package main.java.object_transfer_socket_java_to_java.shared;


// This is an example class we want to send as json strong to server or receive from server
// output is expected to be: {"id":1,"name":"test"}
public class Student {

    private int id;
    private String name;

    // needs default constructor to deserialize from json
    public Student() {

    }
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
