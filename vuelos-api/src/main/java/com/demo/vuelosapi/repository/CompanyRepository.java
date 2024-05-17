package com.demo.vuelosapi.repository;

import com.demo.vuelosapi.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
