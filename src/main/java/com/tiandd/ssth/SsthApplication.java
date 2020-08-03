package com.tiandd.ssth;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.tiandd.ssth.api.StartUpRunner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.tiandd.**.mapper")
@SpringBootApplication
@EnableSwagger2Doc
public class SsthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsthApplication.class, args);
    }

    @Bean
    public StartUpRunner startUpRunner(){
        return new StartUpRunner();
    }
}
