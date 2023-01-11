package com.dbpostgresql.postgresql.repository;

import com.dbpostgresql.postgresql.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserDto, Long>{
}
