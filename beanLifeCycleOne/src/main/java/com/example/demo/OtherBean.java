package com.example.demo;

public class OtherBean {
private int id;
private String depName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "OtherBean{" +
                "id=" + id +
                ", depName='" + depName + '\'' +
                '}';
    }
}
