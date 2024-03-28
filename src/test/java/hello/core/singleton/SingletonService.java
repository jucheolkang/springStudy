package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }
    private SingletonService() {
    } // private를 이용해 다른 곳에서 생성 방지

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
