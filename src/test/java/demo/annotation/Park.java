package demo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

@Slf4j
@PropertySources({
        @PropertySource("classpath:/park-detail.properties"),
        @PropertySource("classpath:/schedule-detail.properties")
})
@Import(Zoo.class)
@Configuration
@EnableAsync
@EnableScheduling
public class Park {
    @Value("${park.name}")
    private String name;
    @Value("${park.address}")
    private String address;
    @Value("${park.phone}")
    private String phone;
    @Value("${park.price}")
    private Float price;

    //@Async
    @Bean
    @Scheduled(fixedRate = 10000)
    void broadcast() {
        log.info("尊敬的游客您好，请您看管自身的随身物品，照顾好老人与小孩！");
    }
    /*public void broadcast() {
        while (true) {
            log.info("尊敬的游客您好，请您看管自身的随身物品，照顾好老人与小孩！");
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

    @Schedules({
            @Scheduled(fixedRate = 10000),
            @Scheduled(cron = "0/20 * * * * ? ")
    })
    private void bus() {
        log.info("尊敬的游客您好，我们园内班车出发了，如有需要可在各个上车点等候！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}

