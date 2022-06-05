package hello.aop.exam;

import hello.aop.member.exam.ExamService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(ExamAnnotation.AopConfig.class)
@Slf4j
public class ExamAnnotation {

    @Autowired
    public ExamService examService;

    @Test
    void annotationTest() {
        for (int i = 0; i < 5; i++) {
            examService.request("1234");
        }

    }

    @Aspect
    @Slf4j
    static class AopConfig {

        @Around("@annotation(hello.aop.member.annotation.Trace)")
        public Object exceptionLog(ProceedingJoinPoint joinPoint) throws Throwable {
            Object result = null;
            try {
                result = joinPoint.proceed();
            } catch (Exception e) {
                log.info("e ",e);
            }

            return result;
        }




    }



}
