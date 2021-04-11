package com.cg.stockapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.stockapp.entities.Company;
import com.cg.stockapp.exceptions.DuplicateCompanyException;
import com.cg.stockapp.repository.CompanyRepository;

@Service
public class CompanyService implements ICompanyService{

	@Autowired
	CompanyRepository repo;
	
	@Override
	public boolean addCompany(Company company) {
		
		if(repo.existsById(company.getCompanyId()))
			throw new DuplicateCompanyException("Company already exists with id "+company.getCompanyId());
		else {
			repo.save(company);
			return true;
		}
	}
		@Override
	public List<Company> getAllCompanyInfo() {
		if (repo.findAll().isEmpty())
			throw new EmptyTableException("No Data Found in the database");
		else
			return repo.findAll();
	}

	@Override
	public Company getCompanyDetails(String companyId) {
		Optional<Company> opt=repo.findById(companyId);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public boolean updateCompanyInfo(Company info) {
		if(repo.existsById(info.getCompanyId())) {
			repo.save(info);
			return true;
		}
			return false;
	}

	@Override
	public boolean deleteCompanyInfo(String companyId) {
		if(repo.existsById(companyId)) {
			repo.deleteById(companyId);
			return true;
		}
			return false;
	}
}
