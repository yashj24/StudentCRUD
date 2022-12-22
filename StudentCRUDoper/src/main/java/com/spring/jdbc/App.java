package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao sd = context.getBean("sdi",StudentDao.class);
        Student st = new Student();
        //st.setId(103);
        st.setName("Yash");
        st.setCity("Indore");
        st.setPercentage(98);
        st.setContact("38738204");
        int res  = sd.update(st,103);
        
        System.out.println(res);
    List<Student> students = sd.getAllStudent();
    for(Student s:students) {
    System.out.println(s);
    }
        
    }
}
