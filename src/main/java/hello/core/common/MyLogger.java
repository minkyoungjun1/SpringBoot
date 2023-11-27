package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
// proxyMode = ScopedProxyMode.TARGET_CLASS
// 가짜 프록시 객체는 요청이 오면 그때 내부에서 진짜 빈을 요청하는 위임 로직이 들어있음
// 클라이언트가 myLogger.logic()을 호출하면 사실은 가짜 프록시 객체의 메서드를 호출한 것이다.
// 가짜 프록시 객체는 request 스코프의 진짜 myLogger.logic()를 호출한다.

public class MyLogger {
    // 로그 출력하기 위한 MyLogger 클래스
    // 이 빈은 HTTP 요청 당 하나씩 생성되고, HTTP 요청이 씉나는 시점에 소멸된다.

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + message);
    }

    @PostConstruct // 빈이 생성되는 시점에 자동으로 초기화 메서드를 사용해서 uuid를 생성한 후 저장
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create : " + this);
    }

    @PreDestroy // 빈이 소멸되는 시점에 종료 메세지를 남긴다
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close : " + this);
    }

}
