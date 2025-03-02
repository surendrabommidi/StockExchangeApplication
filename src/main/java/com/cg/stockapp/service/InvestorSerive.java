package com.cg.stockapp.service;

import java.util.List;

import com.cg.stockapp.entities.Investor;

public interface InvestorSerive {
	
	public List<Investor> getAllInvestor();
	
	public boolean addInvestor(Investor inv);
	
	public boolean deleteInvestor(Investor inv);
	
//	public Investor getInvestorDetails(String investorId);
//	public Investor updateInvestor(Investor info);
//	public List<Investor> viewAlInvestor(Stock stock);
//	public List<Investor> viewAllInvestor(Company company);
//	public Investor buyStock(Stock stock, Investor investor, int quantity);
//	public Investor sellStock(Stock stock, Investor investor, int quantity);
	
}
