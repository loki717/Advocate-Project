package advocate.amdocs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;



import advocate.amdocs.dao.CustomerDao;
import advocate.amdocs.entity.Customer;
import advocate.amdocs.util.CustomerDbUtil;

public class CustomerDaoDbImpl implements CustomerDao {
	
	private static final String INSERT_EMPLOYEE="insert into customers(first_name, last_name, gender,age,phone_number,address) values(?,?,?,?,?,?)";
    
	private  Connection connection=CustomerDbUtil.getConnection();
	
	
	/*
	 * for adding the customer details in to the database
	 */
	
	@Override
	public boolean add(Customer customer) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(INSERT_EMPLOYEE);
		ps.setString(1, customer.getFirstName());
		ps.setString(2, customer.getLastName());
		ps.setString(3, customer.getGender());
		ps.setInt(4, customer.getAge());
		ps.setLong(5, customer.getPhoneNumber());
		ps.setString(6, customer.getAddress());
		int executeUpdate = ps.executeUpdate();
		ps.close();
		if(executeUpdate>0) {
			System.out.println("\n Record Successfully Added");
			return true;
		}
		
		return false;
	}
	
	/*
	 * for modifying the customer details in the database
	 */
	
	@Override
	public boolean modify(int id, Customer customer) {
		PreparedStatement p=null;
		try {
		String sql = "UPDATE customers SET first_name = ?,last_name=?,gender=?,age=?,phone_number=?,address=? WHERE cid = ?";
		p= connection.prepareStatement(sql);
		p.setString(1, customer.getFirstName());
		p.setString(2, customer.getLastName());
		p.setString(3, customer.getGender());
		p.setInt(4,customer.getAge());
		p.setLong(5, customer.getPhoneNumber());
		p.setString(6, customer.getAddress());
		p.setInt(7, id);
		int rowsAffected = p.executeUpdate();
		if (rowsAffected > 0) {
            System.out.println("Record updated successfully!");
            return true;
        } 


		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return false;
	}

	/*
	 * for deleting the customer details that  already registered
	 */

	@Override
	public void delete(int id) {
		
		PreparedStatement p=null;
		try{
            String sql="delete from customers where cid=?";
             p =connection.prepareStatement(sql);
             p.setInt(1, id);
            p.execute();
        }catch(SQLException  e){
            System.out.println(e);
            
        }
	
	}

	/*
	 * for finding and displaying the customer details of a customer
	 */
	@Override
	public List<Customer> findCustomer(int id)  {
		 PreparedStatement p = null;
				 
	        ResultSet rs = null;
	        List<Customer> li=new ArrayList<>();
	       try {
	    	   String sql="select * from customers where cid=?";
	    	  
	    	   p=connection.prepareStatement(sql);
	    	   p.setInt(1, id);
	            rs = p.executeQuery();
	            
	 if(rs.next()) {
	                Customer customer = new Customer();
					customer.setCustomerId(rs.getInt(1));
	                customer.setFirstName(rs.getString(2));
	                customer.setLastName(rs.getString(3));
	                customer.setGender(rs.getString(4));
	                customer.setAge(rs.getInt(5));
	                customer.setPhoneNumber(rs.getLong(6));
	                customer.setAddress(rs.getString(7));
	                li.add(customer);
	       }
	 else
		 {
		 System.out.println("Record Was Not Found");
		 }
		 }
	       catch(SQLException e)
	       {
	    	   System.out.println(e);
	       }
	               
		return li;
	 
		
	}
	
	
	/*
	 * for displaying all the customers
	 */
	
	@Override
	public List<Customer> findAll() {
	        PreparedStatement p = null;
	        ResultSet rs = null;
	        List<Customer> li=new ArrayList<>();
	 
	        try {
	 
	            String sql = "select * from customers";
	            p = connection.prepareStatement(sql);
	            rs = p.executeQuery();
	 
	           
	 
	            while (rs.next()) {
	 
	                Customer customer = new Customer();
					customer.setCustomerId(rs.getInt(1));
	                customer.setFirstName(rs.getString(2));
	                customer.setLastName(rs.getString(3));
	                customer.setGender(rs.getString(4));
	                customer.setAge(rs.getInt(5));
	                customer.setPhoneNumber(rs.getLong(6));
	                customer.setAddress(rs.getString(7));
	                li.add(customer);
	               
	            }
	        }
	 
	       
	        catch (SQLException e) {
	 
	            // Print exception pop-up on screen
	            System.out.println(e);
	        }
		
		return li;
	}




	
	

}
