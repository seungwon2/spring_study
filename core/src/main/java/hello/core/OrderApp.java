package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        //주문하려면 멤버 생성이 필요하니까 멤버 서비스도 객체로 가져옴
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        //null넣기 위해 long에 레퍼런스타입 사용
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //order를 create해봄
        Order order = orderService.createOrder(memberId, "ItemA", 10000);

        System.out.println("order= "+order);
    }
}
