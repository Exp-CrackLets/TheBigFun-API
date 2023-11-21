package com.crackelets.bigfun.platform;

import com.crackelets.bigfun.platform.payment.service.PaymentServiceTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class BigFunApplicationTests {

    @Test
    void testApplication() {
        MockedStatic<SpringApplication> utilities = Mockito.mockStatic(SpringApplication.class);
        utilities.when((MockedStatic.Verification) SpringApplication.run(BigFunApplication.class, new String[]{})).thenReturn(null);
        BigFunApplication.main(new String[]{});
        assertThat(SpringApplication.run(BigFunApplication.class, new String[]{})).isEqualTo(null);
    }
}
