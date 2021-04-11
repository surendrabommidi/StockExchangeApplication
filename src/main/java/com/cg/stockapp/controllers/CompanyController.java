package com.cg.stockapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.stockapp.entities.Company;
import com.cg.stockapp.service.ICompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	ICompanyService serv;

	@PostMapping
	public String addCompany(@RequestBody Company company) {
		serv.addCompany(company);
		return "Company added successfully";
	}
	
		public List<Company> getAllCompanyInfo() {
		List<Company> list = serv.getAllCompanyInfo();
		if (list.size() == 0)
			throw new EmptyTableException("company information not found in database");
		return list;
	}

	@GetMapping(value = "{CompanyDetails}")
	public ResponseEntity<?> getCompanyDetails(@PathVariable("CompanyDetails") String companyId) {
		Company c = serv.getCompanyDetails(companyId);
		if (c == null)

			throw new CompanyNotFoundException("Request", "Company with id " + companyId + "Not found");
		else
			return new ResponseEntity<Company>(c, HttpStatus.OK);

	}

	@PutMapping
	public String updateCompany(@RequestBody Company CompanyInfo) {
		if (serv.updateCompanyInfo(CompanyInfo))
			return "company data sucessfully updated";
		else
			throw new CompanyNotFoundException("update",
					"company with Id" + CompanyInfo.getCompanyId() + "to update not found");

	}
	
	@DeleteMapping("{eid}")
	public String deleteCompany(@PathVariable("eid") String CompanyInfo) {
		if(serv.deleteCompanyInfo(CompanyInfo))
			return "Company data sucessfully deleted";
		else
			throw new CompanyNotFoundException("delete","Company with Id" + CompanyInfo+"Delete not found");
	}


}
