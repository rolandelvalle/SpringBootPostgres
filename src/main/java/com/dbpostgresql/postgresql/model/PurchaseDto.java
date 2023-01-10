package com.dbpostgresql.postgresql.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "purchases")
public class PurchaseDto {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "full_name")
    private String fullName;
    private LocalDate birthDate;
    private String email;

    @ManyToOne
    private UserDto userDto;


}
