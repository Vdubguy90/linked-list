
package other;

public class ClassAB implements B {


    public ClassAB() {
        System.out.println("ClassAB");
    }

    @Override
    public void a() {
        System.out.println("a");
    }

    @Override
    public void b() {
        System.out.println("b");
    }

}
