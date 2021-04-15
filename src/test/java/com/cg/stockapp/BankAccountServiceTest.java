package com.cg.stockapp.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.stockapp.entities.BankAccount;
import com.cg.stockapp.repository.BankAccountRepository;
import com.cg.stockapp.service.BankAccountService;

@SpringBootTest
class BankAccountServiceTest {

	/*
	 * @Test void test() { fail("Not yet implemented"); }
	 */

	@Autowired
	private BankAccountService bankAccountService;

	@MockBean
	private BankAccountRepository bankAccountRepository;

	@Test
	@DisplayName("Test for adding bank account")
	public void addBankAccountServiceTest() {
		BankAccount bankaccount = new BankAccount(12345678L, "Indian", "bhimavaram", "IDIB000K085");
		when(bankAccountRepository.save(bankaccount)).thenReturn(bankaccount);
		assertEquals(true, bankAccountService.addBankAccount(bankaccount));
	}

}
