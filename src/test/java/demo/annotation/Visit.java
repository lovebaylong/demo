package demo.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Visit {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Park.class);
        Park park = ctx.getBean(Park.class);
        System.out.println("公园名称：" + park.getName());
        System.out.println("公园地址：" + park.getAddress());
        System.out.println("公园电话：" + park.getPhone());
        System.out.println("公园门票：" + park.getPrice());

        //park.broadcast();
        //park.bus();


        System.out.println("我们开园接客了！！！");
    }
}
