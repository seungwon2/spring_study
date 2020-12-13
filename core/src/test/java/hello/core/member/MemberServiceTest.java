package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        //given - 이게 주어졌다
        Member member = new Member(1L, "A", Grade.VIP);

        //when - ~할 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then - 이렇게 된다
        //Assertj 라이브러리 이용한 Assertions 쓰면 됨
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
