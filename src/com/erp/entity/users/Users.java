package com.erp.entity.users;

import net.sf.oval.constraint.Email;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;

@Table(name = "USERS")
@Entity(name = "users")
public class Users implements Serializable {
    @Id
    @SequenceGenerator(name = "USERS_SEQ",sequenceName = "USERS_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "USERS_SEQ")
    private long id;
    @NotNull
    @NotEmpty
    @Column(name = "PASSWORD",columnDefinition = "NVARCHAR2(128)")
    private String password;
    @Email
    @NotEmpty
    @NotNull
    @Column(name = "EMAIL",columnDefinition = "NVARCHAR2(40)")
    private String email;
    @NotNull
    @NotEmpty
    @Column(name = "FIRST_NAME", columnDefinition = "NVARCHAR2(20)")
    private String firstName;
    @NotNull
    @NotEmpty
    @Column(name = "LAST_NAME", columnDefinition = "NVARCHAR2(20)")
    private String lastName;
    @Column(name = "IMAGE",columnDefinition = "NVARCHAR2(200)")
    private String image;
    @Column(name = "DATA")
    private String date;

    public Users() {
    }

    public Users(String password, String email, String firstName, String lastName, String image, String date) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
