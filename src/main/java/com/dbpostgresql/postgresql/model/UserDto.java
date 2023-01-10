package com.dbpostgresql.postgresql.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "full_name")
    private String fullName;
    private LocalDate birthDate;
    private String email;

    @OneToMany(mappedBy = "userDto")
    List<PurchaseDto> purchaseDtos;

    public UserDto(){

    }


}
