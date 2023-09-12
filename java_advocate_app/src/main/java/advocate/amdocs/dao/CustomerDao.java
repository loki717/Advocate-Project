package advocate.amdocs.dao;

import java.sql.*;
import java.util.List;


import advocate.amdocs.entity.Customer;

public interface CustomerDao {
	boolean add(Customer customer) throws SQLException ;
	
	boolean modify(int id,Customer customer);
	void delete(int id);
	
	List<Customer> findCustomer(int id) ;
	List<Customer> findAll();
	
	

}
