package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //이 클래스에서 메모리를 사용하기 위해서는 메모리 멤버 리퍼지토리를 가져와야 함
    private final MemberRepository memberRepository = new MemoryMemberRepository();

   //회원 가입, 메모리에 있는 세이브 기능 호출
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    //멤버 아이디로 멤버 찾기, 메모리에 있는 찾기 기능 호출
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
