package com.spring.pi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "actor_contrat")
public class Actor_Contract implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private Actor actor;


    @ManyToOne
    private Contract contract;

}