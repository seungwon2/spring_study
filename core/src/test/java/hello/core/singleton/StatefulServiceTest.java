package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        statefulService1.order("userA", 10000);
        statefulService2.order("userB", 20000);


        //pirce가 private이고 한 객체를 공유해서 쓰니까 A의 주문 금액이 만원임에도 불구하고 마지막으로 적용된 B의 주문금액 20000원이 출력된다.
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}