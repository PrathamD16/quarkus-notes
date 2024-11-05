package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "author", schema = "quark-jpa")
public class Author extends PanacheEntity {
    private String auth_name;
    private String contact;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuth_name() {
        return auth_name;
    }

    public void setAuth_name(String auth_name) {
        this.auth_name = auth_name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", auth_name='" + auth_name + '\'' +
                ", contact='" + contact + '\'' +
                ", age=" + age +
                '}';
    }
}
