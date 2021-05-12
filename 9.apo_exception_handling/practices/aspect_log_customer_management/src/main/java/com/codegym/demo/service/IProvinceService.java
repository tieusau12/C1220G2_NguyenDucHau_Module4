package com.codegym.demo.service;

import com.codegym.demo.model.Province;

import java.util.List;
import java.util.Optional;

public interface IProvinceService {
    List<Province> findAll();

    Optional<Province> findOne(Long id);

    Province save(Province Province);

    List<Province> save(List<Province> Provinces);

    boolean exists(Long id);

    List<Province> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Province Province);

    void delete(List<Province> Provinces);

    void deleteAll();
}
