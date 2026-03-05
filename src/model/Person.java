
package model;

public class Person implements Comparable<Person> { 

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        int nameCompare = name.compareTo(o.name);
        if (nameCompare == 0) {
            return age - o.age;
        } else {
            return nameCompare;
        }
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }


}
