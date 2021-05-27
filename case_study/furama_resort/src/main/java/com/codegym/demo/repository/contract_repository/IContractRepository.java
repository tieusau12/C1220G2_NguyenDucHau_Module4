package com.codegym.demo.repository.contract_repository;

import com.codegym.demo.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {
//    Page<Contract> findContractByContractDetailsAndStartDateContractAndEnd(String search, Pageable pageable);
}
