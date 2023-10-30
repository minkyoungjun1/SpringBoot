package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 컴포넌트 스캔과 의존관계 자동 주입
@Configuration
@ComponentScan(
        // basePackages : 탐색한 패키지의 시작 위치를 지정한다. 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
        // basePackages = {"hello.core", "hello.service"} 두 개의 패키지 하위 패키지 모두 탐색
//        basePackages = "hello.core.member", // hello.core.member 패키지 부터 하위 패키지까지 ComponentScan 대상지정
//        basePackageClasses = AutoAppConfig.class, // basePackageClasses : 지정한 클래스의 패키지를 탐색 시작위로 지정한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean
//    OrderService orderService(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        return new OrderServiceImpl(memberRepository, discountPolicy);
//    }

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
