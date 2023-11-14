package org.ls_09_11_2023_mockitoTest.praktika.mockito.dummy;

import java.util.*;

public class AddressBook {

	public List<Customer> customers = new ArrayList<>();
	public void addCustomer(Customer customer) {
		if (customer == null) throw new NullPointerException();
		customers.add(customer);
	}
	public int getNumberOfCustomers() {
		return customers.size();
	}
}
