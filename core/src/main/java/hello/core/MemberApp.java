package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        //새로운 멤버 만들어서 멤버 서비스에 넣기
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "A", Grade.VIP);
        memberService.join(member);
        //멤버 서비스에서 꺼내오기
        Member findMember = memberService.findMember(1L);
        //멤버 이름 비교
        System.out.println("new member: " + member.getName());
        System.out.println("find member: " + findMember.getName());

    }
}
