package com.erp.entity.box;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "BOX")
@Entity(name = "box")
public class Box implements Serializable {
    @Id
    @SequenceGenerator(name = "BOX_SEQ",sequenceName = "BOX_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "BOX_SEQ")
    private long id;
    @NotNull
    @NotEmpty
    @Column(name = "NAME",columnDefinition = "NVARCHAR2(40)")
    private String name;
    @NotNull
    @NotEmpty
    @Column(name = "PRICE",columnDefinition = "NVARCHAR2(40)")
    private String price;
    @NotNull
    @NotEmpty
    @Column(name = "DESCRIPTION",columnDefinition = "NVARCHAR2(100)")
    private String description;
    public Box() {
    }

    public Box(String name, String price, String image,String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
