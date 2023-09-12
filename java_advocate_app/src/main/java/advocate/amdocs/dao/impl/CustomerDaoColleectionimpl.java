package advocate.amdocs.dao.impl;

import java.util.*;



import advocate.amdocs.dao.CustomerDao;
import advocate.amdocs.entity.Customer;

public class CustomerDaoColleectionimpl implements CustomerDao {
	List<Customer> customers =new ArrayList<>();

	public boolean add(Customer customer) {
		return customers.add(customer);		
	}
	
	@Override
	public List<Customer> findAll() {		
		return customers;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> findCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(int id, Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
