package advocate.amdocs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import advocate.amdocs.dao.AppointmentDao;
import advocate.amdocs.entity.Appointment;
import advocate.amdocs.entity.Customer;
import advocate.amdocs.util.CustomerDbUtil;

public class AppointmentDaoDbImpl implements AppointmentDao {

private static final String INSERT_APPOINTMENT="insert into appointments(c_id, appointment_date, appointment_time,phone_number,place) values(?,?,?,?,?)";
    
	private  Connection connection=CustomerDbUtil.getConnection();
	
	
	/*
	 * for adding the appointment details in to the database
	 */
	
	@Override
	public boolean add(Appointment appointment) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(INSERT_APPOINTMENT);
		ps.setInt(1, appointment.getCustomerId());
		ps.setString(2, appointment.getDate());
		ps.setString(3, appointment.getTime());
		ps.setLong(4, appointment.getCustomerPhoneNumber());
		ps.setString(5, appointment.getPlace());
		int executeUpdate = ps.executeUpdate();
		ps.close();
		if(executeUpdate>0) {
			return true;
		}
		return false;
	}
	

	/*
	 * for modifying the appointment details in the database
	 */

	@Override
	public boolean modify(int id, Appointment appointment) {
		
		PreparedStatement p=null;
		try {
		String sql = "UPDATE appointments SET appointment_date = ?,appointment_time=?,phone_number=?,place=? WHERE appointment_id = ?";
		p= connection.prepareStatement(sql);
		p.setString(1, appointment.getDate());
		p.setString(2, appointment.getTime());
		p.setLong(3, appointment.getCustomerPhoneNumber());
		p.setString(4,appointment.getPlace());
		p.setInt(5, id);
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
	 * for deleting the appointment already booked
	 */

	@Override
	public void delete(int id) {
		PreparedStatement p=null;
		try{
            String sql="delete from appointments where appointment_id=?";
             p =connection.prepareStatement(sql);
             p.setInt(1, id);
            p.execute();
        }catch(SQLException  e){
            System.out.println(e);
            
        }
		
	}

	
	/*
	 * for finding and displaying the appointment details of a customer
	 */
	

	@Override
	public List<Appointment> findAppointment(int id) {
		PreparedStatement p = null;
		 
        ResultSet rs = null;
        List<Appointment> li=new ArrayList<>();
       try {
    	   String sql="select * from appointments where appointment_id=?";
    	  
    	   p=connection.prepareStatement(sql);
    	   p.setInt(1, id);
            rs = p.executeQuery();
            
 if(rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt(1));
                appointment.setCustomerId(rs.getInt(2));
                appointment.setDate(rs.getString(3));
                appointment.setTime(rs.getString(4));
                appointment.setCustomerPhoneNumber(rs.getLong(5));
                appointment.setPlace(rs.getString(6));
                
                li.add(appointment);
			
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
	 * for displaying all the appointments booked
	 */


	@Override
	public List<Appointment> findAllAppointments() {
		 PreparedStatement p = null;
	        ResultSet rs = null;
	        List<Appointment> li=new ArrayList<>();
	 
	        try {
	 
	            String sql = "select * from appointments";
	            p = connection.prepareStatement(sql);
	            rs = p.executeQuery();
	 
	           
	 
	            while (rs.next()) {
	            	Appointment appointment = new Appointment();
	                appointment.setAppointmentId(rs.getInt(1));
	                appointment.setCustomerId(rs.getInt(2));
	                appointment.setDate(rs.getString(3));
	                appointment.setTime(rs.getString(4));
	                appointment.setCustomerPhoneNumber(rs.getLong(5));
	                appointment.setPlace(rs.getString(6));
	                
	                li.add(appointment);

	               
	            }
	        }
	 
	       
	        catch (SQLException e) {
	 
	            // Print exception pop-up on screen
	            System.out.println(e);
	        }
		
		return li;

	}



}
