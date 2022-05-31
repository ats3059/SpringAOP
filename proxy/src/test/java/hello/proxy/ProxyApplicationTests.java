package hello.proxy;

import hello.proxy.app.v1.OrderControllerV1;
import hello.proxy.app.v1.OrderServiceV1;
import hello.proxy.config.DynamicProxyFilterConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
class ProxyApplicationTests {
	private final ApplicationContext ac;

	@Test
	void contextLoads() {
		log.info("ContainerClass = {} " ,ac.getClass());
		DynamicProxyFilterConfig bean = ac.getBean(DynamicProxyFilterConfig.class);
		OrderServiceV1 bean1 = ac.getBean(OrderServiceV1.class);
		log.info("order class = {}", bean1.getClass());
		log.info("bean class = {}", bean.getClass());
	}

}
