package hello.core.singleton;

public class SingletonService {
    // 싱글톤 패턴
    // 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴
    // 객체 인스턴스가 2개 이상 생성하지 못하도록 막아야한다.
    // private 생성자를 사용해서 외부에서 임의로 new 키워드를 사용하지 못하도록 막아야 한다.

    // static를 사용해서 class 레벨에 올라가기 때문에 딱 하나만 존재함
    private static final SingletonService instance = new SingletonService(); // 자기 자신의 객체를 생성해서 instance에 넣어놓음

    // public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체생성을 못하게 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
