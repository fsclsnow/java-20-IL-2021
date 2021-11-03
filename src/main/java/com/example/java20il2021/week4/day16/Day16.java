package com.example.java20il2021.week4.day16;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 *   Spring :
 *      IOC :
 *          @Component, @Service, @Repository, @Controller / @Bean
 *          bean scope : singleton(default), prototype, request, session, global session
 *          @Autowired : field injection / setter injection / constructor injection
 *          by name / by type
 *
 *      AOP :
 *          point cutting
 *          joint point
 *          advice
 *   Spring Boot :
 *      1. auto configuration
 *      2. application.properties
 *      3. embedded tomcat + main method starter
 *      4. actuator
 *      5. microservice
 *
 *   <bean name="", id="", location=""/>
 *   <hibernate >
 *      <SessionFactory>
 *          <Entity>
 *              <Attribute>
 *
 *              </Attribute>
 *              <Attribute>
 *
 *              </Attribute>
 *          </Entity>
 *      </SessionFactory>
 *   </hibernate>
 *
 *   server[tomcat[war file]] vs client
 *   servlet  /user -> UserServlet
 *   connection1 -> ThreadPool
 *            T1 -> connection1
 *            T2 -> connection2
 *
 */

@SpringBootApplication
public class Day16 {
    @Autowired
    @Qualifier("studentServiceImpl1")
    private StudentService s1;

    @Autowired
    @Qualifier("studentServiceImpl1")
    private StudentService s2;
//    @Autowired
//    public Day16 (StudentServiceImpl1 s1, StudentServiceImpl1 s2 ){
//        this.s1 = s1;
//        this.s2 = s2;
//    }

//    public void increment() {
//        s1.increment();
//        s2.increment();
//    }

    public static void main(String[] args) {
        SpringApplication.run(Day16.class, args);
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s1 == s2);
    }
}

/**
 *  Day16 singleton instance d16  {singleton s1, s2}
 *  T1 -> d16.print();
 *  T2 -> d16.print();
 *  T3 -> d16.print();
 */

interface StudentService {
    void increment();
}
@Component
@Scope("prototype")
class StudentServiceImpl1 implements StudentService{

    @Override
    public void increment() {
        int a = 5;
    }
}
@Component
class StudentServiceImpl2 implements StudentService{
    @Override
    public void increment() {
        int a = 5;
    }
}



