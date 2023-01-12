package com.dbpostgresql.postgresql.controller;

import com.dbpostgresql.postgresql.exceptions.UserExceptions;
import com.dbpostgresql.postgresql.model.PurchaseDto;
import com.dbpostgresql.postgresql.model.UserDto;
import com.dbpostgresql.postgresql.repository.PurchaseRepository;
import com.dbpostgresql.postgresql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/purchases")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public ResponseEntity<PurchaseDto> createUser(@RequestBody PurchaseDto purchaseDto) {
        return new ResponseEntity<>(purchaseRepository.save(purchaseDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseDto>> getAll(){
        return new ResponseEntity<>(purchaseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PurchaseDto findById(@PathVariable Long id) {
        Optional<PurchaseDto> optionalPurchaseDto = purchaseRepository.findById(id);
        if (optionalPurchaseDto.isPresent()) {
            return optionalPurchaseDto.get();
        } else throw new UserExceptions();
    }


}
