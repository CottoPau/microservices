package com.demo.vuelosapi.service;

import com.demo.vuelosapi.exceptions.ResourceNotFoundExceptions;
import com.demo.vuelosapi.model.Company;
import com.demo.vuelosapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    public List<Company> getAllCompanies(){return companyRepository.findAll();}

    public void createCompany(Company company) {
        companyRepository.save(company);

    }

    public Optional<Company> searchCompanyById(Long id) {
        return companyRepository.findById(id);

    }

    public void removeCompanyById(Long id) throws ResourceNotFoundExceptions {
        Company company =companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExceptions("Company", "id", id));
        companyRepository.deleteById(id);
    }

    public Optional<Company> updateCompany(Company company){
        companyRepository.save(company);
        return companyRepository.findById(company.getId());
    }


}
