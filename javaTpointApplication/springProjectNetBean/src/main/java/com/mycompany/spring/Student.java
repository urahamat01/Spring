

package com.mycompany.spring;



public class Student {
    
    //create java class
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void displayInfo(){
        
        System.out.println("Hello" +name);
        
    
    }
    
}
