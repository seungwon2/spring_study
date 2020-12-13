package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {
    //주문하려면 멤버 생성이 필요하니까 멤버 서비스도 객체로 가져옴
    MemberService memberService;
    OrderService orderService;

    //테스트 실행 전 무조건 실행되는 것
    //테스트 개수 만큼 돌아감
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    //null넣기 위해 long에 레퍼런스타입 사용
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //order를 create
        Order order = orderService.createOrder(memberId, "ItemA", 10000);

        //할인된 가격이 1000원이 맞는지 확인
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
