//package com.codegym.demo.service.contract_service.impl;
//
//import com.codegym.demo.model.contract.AttachService;
//import com.codegym.demo.model.contract.Contract;
//import com.codegym.demo.model.contract.ContractDetail;
//import com.codegym.demo.repository.contract_repository.IAttachServiceRepository;
//import com.codegym.demo.repository.contract_repository.IContractDetailRepository;
//import com.codegym.demo.repository.contract_repository.IContractRepository;
//import com.codegym.demo.service.contract_service.IContractService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ContractServiceImpl implements IContractService {
//    @Autowired
//    private IContractRepository contractRepository;
//    @Autowired
//    private IContractDetailRepository contractDetailRepository;
//    @Autowired
//    private IAttachServiceRepository attachServiceRepository;
//
//
//    @Override
//    public void createContract(Contract contract) {
//        contractRepository.save(contract);
//    }
//
//    @Override
//    public Page<Contract> findContract(String search, Pageable pageable) {
//        return contractRepository.findContractByDate(search, pageable);
//    }
//
//    @Override
//    public Page<Contract> findAll(Pageable pageable) {
//        return contractRepository.findAll(pageable);
//    }
//
//    @Override
//    public void createContractDetail(ContractDetail contractDetail) {
//        contractDetailRepository.save(contractDetail);
//    }
//
//    @Override
//    public List<AttachService> findAllAttachService() {
//        return attachServiceRepository.findAll();
//    }
//}
