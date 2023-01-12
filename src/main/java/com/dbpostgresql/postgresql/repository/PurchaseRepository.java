package com.dbpostgresql.postgresql.repository;

import com.dbpostgresql.postgresql.model.PurchaseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<PurchaseDto, Long> {
}
