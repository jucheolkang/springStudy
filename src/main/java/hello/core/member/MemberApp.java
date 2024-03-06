package hello.core.member;

import hello.core.order.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

/*        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // config에 있는 환경 설정 정보를 가지고 @Bean으로 등록된 메소드를 객체생성해서 스프링 컨테이너로 관리
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
//        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
