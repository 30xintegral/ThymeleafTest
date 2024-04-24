package com.example.thymeleaftest.mapper;

import com.example.thymeleaftest.model.Owner;
import com.example.thymeleaftest.model.request.OwnerRequest;
import com.example.thymeleaftest.model.response.OwnerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class OwnerMapper {
    public static final OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

    public abstract OwnerResponse entityToResponse(Owner owner);

    public abstract Owner requestToEntity(OwnerRequest ownerRequest);
}
