package com.codegym.demo.service.contract_service;

import com.codegym.demo.model.contract.AttachService;
import com.codegym.demo.model.contract.Contract;
import com.codegym.demo.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    void createContract(Contract contract);

//    Page<Contract> findContract(String search, Pageable pageable);

    Page<Contract> findAll(Pageable pageable);

    void createContractDetail(ContractDetail contractDetail);

    List<AttachService> findAllAttachService();
}
