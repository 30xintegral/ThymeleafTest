package com.example.thymeleaftest.service;

import com.example.thymeleaftest.model.response.OwnerResponse;

import java.util.List;

public interface OwnerService {
    List<OwnerResponse> findAll();

    OwnerResponse findById(Long id);

}
