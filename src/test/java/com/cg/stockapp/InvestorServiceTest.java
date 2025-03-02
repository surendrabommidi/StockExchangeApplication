package com.cg.stockapp.investorservicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.stockapp.entities.Investor;
import com.cg.stockapp.repository.InvestorRepository;
import com.cg.stockapp.service.InvestorServiceImpl;
@SpringBootTest
class InvestorServiceTest {

	
	@Autowired
	private InvestorServiceImpl investorService;

	@MockBean
	private InvestorRepository investorRepository;
	
	
	@Test
	@DisplayName("Test for adding investor")
	public void addInvestorTest() {
		Investor investor = new Investor("A100", "rams", "surendra@gmail.com", "King@123","9494888152" , "male", "active") ;
		
		when(investorRepository.save(investor)).thenReturn(investor);
		
		assertEquals(true, investorService.addInvestor(investor));
	}
	
	@Test
	@DisplayName("Test for displaying all investor details")
	public void showAllInvestorsTest() {
			when(investorRepository.findAll())
				.thenReturn(Stream.of(new Investor("A100", "rams", "surendra@gmail.com", "King@123","9494888152" , "male", "active"))
					.collect(Collectors.toList()));
		assertEquals(1, investorService.getAllInvestor().size());
	}
	
	@Test
	@DisplayName("Test for updating investor")
	public void updateInvestorTest() {
		Investor investor = new Investor("A100", "rams", "surendra@gmail.com", "King@123","9494888152" , "male", "active") ;
		
		investor.setInvestorName("surendra");
		assertThat(investorRepository.findById(investor.getInvestorId())).isNotEqualTo(investor);
	}
	@Test
	@DisplayName("Test for deleting investor")
	public void deleteInvestorTest() {
		Investor investor = new Investor("A100", "rams", "surendra@gmail.com", "King@123","9494888152" , "male", "active") ;
		
		when(investorRepository.existsById(investor.getInvestorId())).thenReturn(true);
		investorService.deleteInvestor(investor.getInvestorId());
		verify(investorRepository).deleteById("A100");
	}
	@Test
	@DisplayName("Test for deleting investor")
	public void showInvestorTest() {
		Investor investor = new Investor("A100", "rams", "surendra@gmail.com", "King@123","9494888152" , "male", "active") ;
		when(investorRepository.save(investor)).thenReturn(investor);
		assertNotEquals(investor,investorRepository.findById(investor.getInvestorId()));
			

	}
}
