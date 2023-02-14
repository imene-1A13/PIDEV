package com.spring.pi.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "actor")
public class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String FullName;
    @Temporal(TemporalType.DATE)
    private Date Birthdate;
    private  int phone;
    private String gender;
    private String email;
    private String password;
    private String picture;
    private String address;
    @Enumerated(EnumType.STRING)

    private ERole role;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Actor second_actor;


    @ManyToMany(mappedBy = "actors", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Set<Conversation> conversations = new LinkedHashSet<>();


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Generic_Message> generic_Messages = new LinkedHashSet<>();


    @ManyToOne(cascade = CascadeType.ALL)
    private Agency agency;


    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Actor_Contract> actor_Contrats = new LinkedHashSet<>();


}