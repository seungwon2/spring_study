package hello.core.member;

public interface MemberService {

    //서비스는 회원 가입과 회원 조회 두가지 기능 제공
    void join(Member member);

    Member findMember(Long memberId);

}

