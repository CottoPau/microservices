package com.demo.vuelosapi.controller;

import com.demo.vuelosapi.exceptions.ResourceNotFoundExceptions;
import com.demo.vuelosapi.model.Company;
import com.demo.vuelosapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")

public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("")
    public List<Company> getAllCompanies(){return companyService.getAllCompanies();}

    @PostMapping("/create")
    public void createCompany(@RequestBody Company company){companyService.createCompany(company);}

    @GetMapping("/{id}")
    public Optional<Company> findCompanyById(@PathVariable Long id) {
        return companyService.searchCompanyById(id);}

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        try {
            companyService.removeCompanyById(id);
            return "Company Delete ok";
        } catch (ResourceNotFoundExceptions e) {
            e.printStackTrace();
            return "Company Not Found";
        }
    }


    @PutMapping("/update")
    public Company company(@RequestBody Company company){
        companyService.updateCompany(company);
        return company;
    }



}