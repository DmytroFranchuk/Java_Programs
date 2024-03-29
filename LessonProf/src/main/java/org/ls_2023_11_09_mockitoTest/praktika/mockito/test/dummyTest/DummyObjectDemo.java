package org.ls_2023_11_09_mockitoTest.praktika.mockito.test.dummyTest;

import org.junit.jupiter.api.Test;
import org.ls_2023_11_09_mockitoTest.praktika.mockito.dummy.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DummyObjectDemo {

	/*
	 * Scenario 1. Standard use case
	 */
	public Customer createDummyCustomer() {
		State state = new State("CA");
		City city = new City("Los Angeles", state);
		Address address = new Address("Mulholland Drive", city);
		return new Customer("Jack", "Nicholson", address);
	}

	@Test
	public void addCustomerTest() {
		Customer dummy = createDummyCustomer();
		AddressBook addressBook = new AddressBook();
		addressBook.addCustomer(dummy);
		assertEquals(1, addressBook.getNumberOfCustomers());
	}

	/*
	 * Scenario 2. Must deal with an exception on null dummy
	 */
	@Test
	public void addNullCustomerTest() {
		Customer dummy = null;
		AddressBook addressBook = new AddressBook();
		assertThrows(NullPointerException.class, () -> addressBook.addCustomer(dummy));
	}

	/*
	 * Scenario 3. Avoid exceptions altogether by injecting a mock object
	 */
	@Test
//	@ExtendWith(MockitoExtension.class)
	public void addCustomerWithDummyTest() {
		Customer dummy = Mockito.mock(Customer.class);
		AddressBook addressBook = new AddressBook();
		addressBook.addCustomer(dummy);
		assertEquals(1, addressBook.getNumberOfCustomers());
	}
}