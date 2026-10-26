package com.security.security_p3_jwt.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public Permission(){}

    public Permission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
