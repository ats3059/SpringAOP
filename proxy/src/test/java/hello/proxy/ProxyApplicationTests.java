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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
class ProxyApplicationTests {


	@Test
	void contextLoads() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestA.class);
		TestB bean = ac.getBean(TestB.class);
		TestA bean2 = ac.getBean(TestA.class);
		log.info("beanClass = {} " , bean2.getClass());
		log.info("beanClass = {} " , bean.getClass());

	}

	@Configuration
	static class TestA{
		@Bean
		public TestB testB() {
			return new TestB();
		}
	}

	@Slf4j
	static class TestB{
		public void call() {
			log.info("callB");

		}
	}

}
