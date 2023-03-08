package br.com.topone.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"br.*"}) /*Mapeamento dos pacotes*/
@EnableJpaRepositories(basePackages = {"br.com.topone.ecommerce.repository"}) /*Mapeamento dos pacotes dos Repositorios*/
@EnableTransactionManagement /*Transações que serão feitas pelo projeto*/
public class ECommerceApplication {

    public static void main(String[] args) {

//        System.out.println(new BCryptPasswordEncoder().encode("123456"));


        SpringApplication.run(ECommerceApplication.class, args);
    }

}
