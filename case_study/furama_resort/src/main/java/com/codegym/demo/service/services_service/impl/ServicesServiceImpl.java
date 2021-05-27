//package com.codegym.demo.service.services_service.impl;
//
//import com.codegym.demo.model.services.RentTypeService;
//import com.codegym.demo.model.services.Service;
//import com.codegym.demo.model.services.TypeService;
//import com.codegym.demo.repository.services_repository.IRenTypeRepository;
//import com.codegym.demo.repository.services_repository.IServiceRepository;
//import com.codegym.demo.repository.services_repository.ITypeServiceRepository;
//import com.codegym.demo.service.services_service.IServicesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//
//import java.util.List;
//
//@org.springframework.stereotype.Service
//public class ServicesServiceImpl implements IServicesService {
//    @Autowired
//    private IServiceRepository serviceRepository;
//
//    @Autowired
//    private ITypeServiceRepository typeServiceRepository;
//
//    @Autowired
//    private IRenTypeRepository renTypeRepository;
//
//
//    @Override
//    public void saveService(Service service) {
//        serviceRepository.save(service);
//    }
//
//    @Override
//    public Service findById(String id) {
//        return serviceRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Page<Service> findAll(Pageable pageable) {
//        return serviceRepository.findAll(pageable);
//    }
//
//    @Override
//    public void deleteById(String id) {
//    serviceRepository.deleteById(id);
//    }
//
//    @Override
//    public TypeService findTypeServiceId(Integer id) {
//        return typeServiceRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<RentTypeService> findAllRentType() {
//        return renTypeRepository.findAll();
//    }
//}
