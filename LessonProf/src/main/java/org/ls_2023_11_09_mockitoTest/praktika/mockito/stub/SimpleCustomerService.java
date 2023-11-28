package org.ls_2023_11_09_mockitoTest.praktika.mockito.stub;

public class SimpleCustomerService implements CustomerService {

	CustomerRepository customerRepository;

	public SimpleCustomerService(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerRepository.getCustomerById(id);
		
	}
}