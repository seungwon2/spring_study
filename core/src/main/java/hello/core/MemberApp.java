package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig 이용
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "A", Grade.VIP);
        memberService.join(member);
        //멤버 서비스에서 꺼내오기
        Member findMember = memberService.findMember(1L);
        //멤버 이름 비교
        System.out.println("new member: " + member.getName());
        System.out.println("find member: " + findMember.getName());

    }
}
