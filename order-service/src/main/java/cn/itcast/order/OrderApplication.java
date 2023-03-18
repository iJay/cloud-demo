package cn.itcast.order;

import cn.itcast.feign.client.UserClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// 方式1. 这里需要指定Feign应该扫描的包 这个包在另外的feign-api模块里
// @EnableFeignClients(basePackages = "cn.itcast.feign.client")
// 方式2. 指定需要加载的Client接口
@EnableFeignClients(clients = {UserClient.class})
@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate () {
        return new RestTemplate();
    }

}