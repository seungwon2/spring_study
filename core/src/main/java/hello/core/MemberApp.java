package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig 이용
        //Application Context = 스프링 컨테이너
        //AnnotationConfig~이거로 가져오고, AppConfig.class를 주입해 AppConfig를 사용한다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //위에 불러온 스프링 컨테이너에서 getBean해서 memberService 메소드를 꺼내옴
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "A", Grade.VIP);
        memberService.join(member);
        //멤버 서비스에서 꺼내오기
        Member findMember = memberService.findMember(1L);
        //멤버 이름 비교
        System.out.println("new member: " + member.getName());
        System.out.println("find member: " + findMember.getName());

    }
}
