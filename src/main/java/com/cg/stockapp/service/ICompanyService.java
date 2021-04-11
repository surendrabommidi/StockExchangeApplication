package com.cg.stockapp.service;

import com.cg.stockapp.entities.Company;

public interface ICompanyService {
	
	public boolean addCompany(Company company);
        public List<Company> getAllCompanyInfo();
	public Company getCompanyDetails(String companyId);
	public boolean  updateCompanyInfo(Company info);
	public boolean deleteCompanyInfo(String companyId);
	
}
