package com.zanol.scheduling.company.repository;

import com.zanol.scheduling.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByCnpj(String cnpj);
}