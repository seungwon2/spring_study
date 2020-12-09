package hello.core.member;

public interface MemberRepository {
    //회원 저장 기능
    void save(Member member);
    //회원 아이디로 회원 찾는 기능
    Member findById(Long memberId);

}
