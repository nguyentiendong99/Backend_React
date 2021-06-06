package com.example.projects.service.impl;

import com.example.projects.domain.Brand;
import com.example.projects.dto.BrandDTO;
import com.example.projects.repository.BrandRepository;
import com.example.projects.service.BrandService;
import com.example.projects.service.mapper.BrandMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public Page<Brand> getListBrand(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Override
    public Page<Brand> getListBrandByAgentId(Integer id , Pageable pageable) {
        return brandRepository.findByAgentId(id , pageable);
    }
}
