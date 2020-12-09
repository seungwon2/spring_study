package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixdiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        //vip일 경우에만 천원 할인 금액을 리턴함
        //enum형은 ==로 비교
        if (member.getGrade() == Grade.VIP){
            return discountFixAmount;
        } else return 0;
    }
}
