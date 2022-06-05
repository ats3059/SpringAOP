package hello.aop.exam;

import hello.aop.member.exam.ExamService;
import hello.aop.member.exam.aop.RetryAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootTest
@Import(RetryAspect.class)
public class ExamTest {

    @Autowired
    ExamService examService;

    @Test
    void test() {
        for (int i = 0; i < 5; i++) {
            log.info("client request i={}" ,i);
            examService.request("data" + i);
        }
    }

}
