package com.wang.freemarker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class FreeApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(FreeApplication.class,args);
    }
    
//    @Bean
//    public CommandLineRunner init() {
//     
//       return (String... strings) -> {
//    	   System.err.print("\n****\n$$$$$$$$测试启动参数$$$$$$$$$$$$\n*****\n");
//       };
//     
//    }
    
 
}
