package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPlicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 정보에 붙이는 어노테이션
public class AppConfig {

    // 역할이 들어나도록 수정

    @Bean // @Bean을 붙이면 해당 메소드가 스프링 컨테이너에 등록된다
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

   /* @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
     @Bean 메서드에 static 키워드가 사용되었을 때
     @Configuration과 @Bean 어노테이션을 사용해도 싱글톤이 보장되지 않는다

    */

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPlicy();
        return new RateDiscountPolicy();
    }

}
