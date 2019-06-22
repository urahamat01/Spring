package com.example.demo;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean{
    private  static final String DEFAULT_NAME = "Mr. Java";
    private String name = null;
    private int age = Integer.MIN_VALUE;
    private OtherBean otherBean;


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOtherBean(OtherBean otherBean) {
        this.otherBean = otherBean;
    }
    public void init(){
        System.out.println("Initializing bean");
        if (name == null){
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE){
            throw new IllegalArgumentException(
                    "You must set the age property of any bean of type"+ SimpleBean.class);

        }
        if (otherBean.getDepName() == null){
            System.out.println("use Default Value");
            otherBean.setDepName("Admin");
        }
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", otherBean=" + otherBean +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:initMethod.xml");
        ctx.refresh();//Refresh the applicationContext after xml config file
        SimpleBean simpleBean1 = (SimpleBean) ctx.getBean("simpleBean1");
        SimpleBean simpleBean2 = (SimpleBean) ctx.getBean("simpleBean2");
        System.out.println(simpleBean1);
        System.out.println(simpleBean2);

    }

    private static SimpleBean getBean(String beanName, ApplicationContext ctx){
        try {
            SimpleBean bean = (SimpleBean) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        }catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configura :" + ex.getMessage());
            return null;
        }
    }
}
