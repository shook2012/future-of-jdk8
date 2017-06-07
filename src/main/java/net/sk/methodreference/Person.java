package net.sk.methodreference;

public class Person {
    private String name;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }

    public int compareTo(Person p) {
        return this.getName().compareTo(p.getName());
    }
}