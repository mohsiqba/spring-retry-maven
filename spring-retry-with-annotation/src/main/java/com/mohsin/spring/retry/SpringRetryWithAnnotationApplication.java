package com.mohsin.spring.retry;

import com.mohsin.spring.retry.service.IBarService;
import com.mohsin.spring.retry.service.IFooService;
import com.mohsin.spring.retry.service.impl.BarService;
import com.mohsin.spring.retry.service.impl.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.retry.annotation.EnableRetry;

@Slf4j
@SpringBootApplication
@EnableRetry(proxyTargetClass = true)
public class SpringRetryWithAnnotationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringRetryWithAnnotationApplication.class, args);
        IFooService fooService = context.getBean(FooService.class);
        log.info("\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜\nfooService.print(foo)\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
        try {
            fooService.print("foo");
            log.info("Recovered");
        } catch (Exception e) {
            log.info("Not recovered: " + e);
        }
        log.info("\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜\nfooService.out(foo)\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
        try {
            fooService.out("foo");
            log.info("Recovered");
        } catch (Exception e) {
            log.info("Not recovered: " + e);
        }
        log.info("\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜\nfooService.print(bar)\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
        try {
            fooService.print("bar");
            log.info("Recovered");
        } catch (Exception e) {
            log.info("Not recovered: " + e);
        }
        log.info("\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜\nfooService.out(bar)\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
        try {
            fooService.out("bar");
        } catch (Exception e) {
            log.info("Not recovered: " + e);
        }

        IBarService barService = context.getBean(BarService.class);
        log.info("\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜\nbarService.print(foo)\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
        try {
            barService.print("foo");
            log.info("Recovered");
        } catch (Exception e) {
            log.info("Not recovered: " + e);
        }
        log.info("\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜\nbarService.out(foo)\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
        try {
            barService.out("foo");
            log.info("Recovered");
        } catch (Exception e) {
            log.info("Not recovered: " + e);
        }
        log.info("\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜\nbarService.print(bar)\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
        try {
            barService.print("bar");
            log.info("Recovered");
        } catch (Exception e) {
            log.info("Not recovered: " + e);
        }
        log.info("\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜\nbarService.out(bar)\n˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜˜");
        try {
            barService.out("bar");
        } catch (Exception e) {
            log.info("Not recovered: " + e);
        }

    }
}