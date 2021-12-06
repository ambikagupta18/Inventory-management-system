package com.example.inventoryman.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "user",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "name is not empty")
    @Size(min = 3, max = 15)
    private String name;

    @NotEmpty(message = "email is not empty")
    //@Email(regexp ="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @Pattern(regexp = "[6-9]{1}[0-9]{9}",message = "Phone number starting with 6-9 and remaining 9 digit with 0-9")
    @Size(min=10,max=10)
    private String phonenumber;


    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Must contain at least one number and one uppercase " +
            "and lowercase letter" + ",\n" + "and at least 8 or more characters")
    @Size(min = 8)
    private String password;

    @ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_item", joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "item_id",referencedColumnName = "id"))

    //private Collection<Role> roles;
    private Collection<Item> items;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
    /*public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }*/


    public User(String name, String email, String phonenumber, String password, Collection<Item> items) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
        this.items = items;
    }

    public User() {
    }

}

