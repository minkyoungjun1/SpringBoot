package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {
    // InitializingBean : 초기화 인터페이스
    // DisposableBean : 소멸 인터페이스

    private String url; // 접속해야할 서버의 URL

    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disConnect() {
        System.out.println("close: " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 프로퍼티들이 세팅이 끝나면 즉, 의존관계 주입이 끝나면 호출
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disConnect();
    }
}
