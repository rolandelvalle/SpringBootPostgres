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

    public UserDto(String fullName, LocalDate birthDate, String email) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PurchaseDto> getPurchaseDtos() {
        return purchaseDtos;
    }

    public void setPurchaseDtos(List<PurchaseDto> purchaseDtos) {
        this.purchaseDtos = purchaseDtos;
    }
}
