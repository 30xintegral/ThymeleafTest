package com.example.thymeleaftest.repository;

import com.example.thymeleaftest.model.Magazine;
import com.example.thymeleaftest.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findAll();
}
