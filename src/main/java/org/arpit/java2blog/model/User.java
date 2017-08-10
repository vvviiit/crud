package org.arpit.java2blog.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private boolean isAdmin;

    @Column
    private Date createdDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User() {
    }

    public User(String name, int age, boolean isAdmin, Date createdDate) {

        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        this.createdDate = createdDate;
    }
}