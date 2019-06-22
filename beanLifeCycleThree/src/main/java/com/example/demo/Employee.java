package com.example.demo;

public class Employee {
    private Long id;
    private String postion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", postion='" + postion + '\'' +
                '}';
    }
    public void initIt() throws Exception{
        System.out.println("Init method after properties are set :" + id +" " +postion);
    }
    public void cleanUp() throws Exception{
        System.out.println("Spring clean up! Employee is cleaned up now.");
    }
}
