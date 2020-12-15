package hello.core.singleton;

public class SingletonService {

    //클래스 안에 static영역에 객체 딱 1개만 생성
    public static final SingletonService instance = new SingletonService();

    //객체 인스턴스가 필요할 때 getinstance메소드 사용해서 꺼내갈 수 있도록 설정
    public static SingletonService getInstance(){
        return instance;
    }

    //private으로 생성자 잠금
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
