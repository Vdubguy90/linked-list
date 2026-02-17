
package test;

import list.*;

public class App {

    private static class MyClass {
        
    }

    public static void main(String[] args) {

        List<Integer> intList = new LinkedList<>();

        intList.add(1);
        intList.add(3);
        intList.add(2);


        System.out.println("intList: " + intList);
        

    }

}
