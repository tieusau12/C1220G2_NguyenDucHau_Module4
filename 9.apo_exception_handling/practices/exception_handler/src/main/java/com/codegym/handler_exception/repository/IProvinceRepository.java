package com.codegym.handler_exception.repository;

import com.codegym.handler_exception.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends JpaRepository<Province,Long> {
}
