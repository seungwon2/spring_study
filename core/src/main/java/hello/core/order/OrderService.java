package hello.core.order;

public interface OrderService {
    //반환은 order객체, 주문할 때 주문자 아이디와 아이템 이름, 아이템 가격 반환
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
