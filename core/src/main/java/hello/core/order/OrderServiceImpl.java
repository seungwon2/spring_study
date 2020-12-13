package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixdiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    //주문할 때 멤버와 할인 가격이 필요하니까 객체로 가져옴
    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //받아온 멤버 아이디로성 메모리에서 멤버 꺼내와 멤버 객체 생성
        Member member = memberRepository.findById(memberId);
        //할인된 가격 반환, discountpolicy에 보내서 vip인지 확인하고 진행
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //위의 정보 다 담은 order객체 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
