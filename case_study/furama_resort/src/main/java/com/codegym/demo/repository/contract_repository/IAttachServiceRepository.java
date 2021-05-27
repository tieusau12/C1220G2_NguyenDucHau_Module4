package com.codegym.demo.repository.contract_repository;

import com.codegym.demo.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachServiceRepository extends JpaRepository<AttachService, Integer> {
}
