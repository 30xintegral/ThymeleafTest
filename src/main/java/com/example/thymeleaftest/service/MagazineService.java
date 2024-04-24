package com.example.thymeleaftest.service;

import com.example.thymeleaftest.model.response.MagazineResponse;

import java.util.List;

public interface MagazineService {
    List<MagazineResponse> findAll();

    MagazineResponse findById(Long id);
}
