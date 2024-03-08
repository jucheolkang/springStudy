package hello.core.beandefinition;


import hello.core.order.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitioinTest {
    AnnotationConfigApplicationContext ac =  new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefiitionNames = ac.getBeanDefinitionNames();
        for (String beanDefiitionName : beanDefiitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefiitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefiitionName + " beanDefinition = " + beanDefinition);
            }
        }
    }
}
