package com.codegym.demo.service.services_service;

import com.codegym.demo.model.services.RentTypeService;
import com.codegym.demo.model.services.Service;
import com.codegym.demo.model.services.TypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServicesService {
    void saveService(Service service);

    Service findById(String id);

    Page<Service> findAll(Pageable pageable);

    void deleteById(String id);

    TypeService findTypeServiceId(Integer id);

    List<RentTypeService> findAllRentType();
}
