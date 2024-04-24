package com.example.thymeleaftest.repository;

import com.example.thymeleaftest.model.Magazine;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Long> {
    List<Magazine> findAll();

    Optional<Magazine> findById(Long id);


}
