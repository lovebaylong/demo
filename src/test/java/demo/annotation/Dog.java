package demo.annotation;

public class Dog implements Animal {
    @Override
    public void shout() {
        System.out.println("汪");
    }
}
