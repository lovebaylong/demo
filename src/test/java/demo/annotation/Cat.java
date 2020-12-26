package demo.annotation;

public class Cat implements Animal {
    @Override
    public void shout() {
        System.out.println("喵");
    }
}
