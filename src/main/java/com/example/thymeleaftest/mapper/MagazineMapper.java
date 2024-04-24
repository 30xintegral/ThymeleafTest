package com.example.thymeleaftest.mapper;

import com.example.thymeleaftest.model.Magazine;
import com.example.thymeleaftest.model.request.MagazineRequest;
import com.example.thymeleaftest.model.response.MagazineResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class MagazineMapper {
    public static final MagazineMapper INSTANCE = Mappers.getMapper(MagazineMapper.class);

    public abstract MagazineResponse entityToResponse(Magazine magazine);

    public abstract Magazine requestToEntity(MagazineRequest magazineRequest);
}
