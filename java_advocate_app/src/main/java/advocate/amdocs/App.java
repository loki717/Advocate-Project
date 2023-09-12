package advocate.amdocs;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import advocate.amdocs.exceptions.SystemException;
import advocate.amdocs.entity.Appointment;
import advocate.amdocs.entity.Customer;
import advocate.amdocs.dao.*;
import advocate.amdocs.dao.impl.*;
public class App 
{
	private static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
  
    	menu();
    }
    
    private static void menu()
    {
    	/*
    	 * code for displaying main menu
    	 */
      	try {
    	while(true){
    	
    	System.out.println("\n ------- Welcome to Advocate System -------------");
    	System.out.println("\n 1.Customer");
    	System.out.println("\n 2.Advocate");
    	System.out.println("\n 3.Appointment");
    	System.out.println("\n 4.Service");
    	System.out.println("\n 5.Exit");
    	System.out.println("\n Please enter your choice");
    	
    	int choice=Integer.parseInt( sc.nextLine());
    	 switch(choice)
    	 {
    	 case 1:
    		 CustomerServices();
    		
    		break;
		case 2:
			AppointmentServices();
    		break;
    	 case 3:
    		 System.out.println("\n This Feature Is Not Available Right Now Please Try Later");
    		 menu();
    		 break;
    	 case 4:
    		 System.out.println("\n This Feature Is Not Available Right Now Please Try Later");
    		 menu();
    		 menu();
    		 break;
    	 case 5:
    		 System.exit(0);
    		 break;
    		 default:
    			 System.out.println("\n Please Try Again");
    			 break;
    			 
    	 }
    	 }
      	}
      	catch(NumberFormatException e)
      	{
      		System.out.println("Please Enter The NumberFormat"+e.getMessage());
      	}
      	catch(Exception e)
      	{
      		System.out.println("error"+e.getMessage());
      	}
    	
    	
    }
    
    /*
     * code for displaying customer services menu
     */
    private static void CustomerServices()
    {
    	 int choice1;
    	 boolean flag=true;
		 try {
		 while(flag) {
		 System.out.println("\n ------- Welcome to customer services -------------");
		 System.out.println("\n 1.Register Customer");
	     System.out.println("\n 2.Modify Customer Details");
	     System.out.println("\n 3.Delete Customer Details");
	     System.out.println("\n 4.View Single Record");
	     System.out.println("\n 5.View All Records");
	     System.out.println("\n 6.Exit");
	     System.out.println("\n Please Enter Your Choice");
	      choice1=Integer.parseInt(sc.nextLine());
	     switch(choice1)
	     {
	     case 1:
	    	 addCustomer();
	    	 break;
	     case 2:
	    	 modifyCustomerDetails();
	    	 break;
	     case 3:
	    	 deleteCustomer();
	    	 break;
	     case 4:
	    
	    	displayCustomer();
	    	 break;
	     case 5:
	    	 displayAllCustomers();
	    	 break;
	     case 6:
	    	flag=false;
	    	 break;
	    	 default:
	    		 System.out.println("\n Wrong input please try again");
	    		 break;
	    		 
	     }
		 }
		 }
		 catch(NumberFormatException e)
		 {
			 System.out.println("Please Enter The NumberFormat"+e.getMessage());
		 }
		 catch(Exception e)
		 {
			 System.out.println("Error"+e.getMessage());
		 }
    }
    
    /*
     * code for displaying appointments menu
     */
    
    private static void AppointmentServices()
    {
    	int choice2;
    	boolean flag=true;
    	try {
		while(flag){
		 System.out.println("\n ------- Welcome to appointment services -------------");
		 System.out.println("\n 1.Book An Appointment");
	     System.out.println("\n 2.Modify Appointment Details");
	     System.out.println("\n 3.Delete An Appointment");
	     System.out.println("\n 4.View Single ");
	     System.out.println("\n 5.View All Records");
	     System.out.println("\n 6.Exit");
	     System.out.println("\n Please Enter Your Choice");
	     choice2=Integer.parseInt(sc.nextLine());
	     
	     switch(choice2)
	     {
	     case 1:
	    	 addAppointment();
	    	 break;
	     case 2:
	    	 modifyAppointmentDetails();
	    	 break;
	     case 3:
	    	 deleteAppointment();
	    	 break;
	     case 4:
	    	 displayAppointment();
	    	 break;
	     case 5:
	    	 displayAllAppointments();
	    	 break;
	     case 6:
	    	flag=false;
	    	 break;
	    	 default:
	    		 System.out.println("\n wrong input please try again");
	    		 break;
	    		 
	     
	     
	     }
	     
	     
		}
    	}
    	catch(NumberFormatException e)
    	{
    		System.out.println("Please Enter The NumberFormat "+e.getMessage());
    	}
    	catch(Exception e)
		 {
			 System.out.println("Error"+e.getMessage());
		 }

		
    }
    
    /*
     * method for taking custom input from the user for customer details
     */
    
    private static Customer createCustomer()
    {
    	Customer obj=new Customer();
    	
    	System.out.println("Enter The First Name: ");
		String firstName = sc.nextLine();
		obj.setFirstName(firstName);
		firstName = obj.getFirstName();
		
		System.out.println("Enter The Last Name: ");
		String lastName = sc.nextLine();
		obj.setLastName(lastName);
		lastName = obj.getLastName();
		
		System.out.println("Enter The Gender: ");
		String gender = sc.nextLine();
		obj.setGender(gender);
		gender = obj.getGender();
		
		System.out.println("Enter The Age: ");
		int age = Integer.parseInt(sc.nextLine());
		obj.setAge(age);
		age = obj.getAge();
		
		
		
		System.out.println("Enter The Phone Number: ");
		long phoneNumber=Long.parseLong(sc.nextLine());
		obj.setPhoneNumber(phoneNumber);
		phoneNumber=obj.getPhoneNumber();
		
		System.out.println("Enter The Address: ");
		String address = sc.nextLine();
		obj.setAddress(address);
		address = obj.getAddress();
		
		return obj;
		
		}
    
    private static CustomerDao dao=new CustomerDaoDbImpl();
    
    
    /*
     * method for adding the customer details into the database by calling add method in the CustomerDaoDblImpl class
     */
    
    public static void addCustomer() throws SQLException, SystemException
    {
    	Customer createCustomer;
    	createCustomer=createCustomer();
    	dao.add(createCustomer);
    	
    }
    
    
    /*
     * method for modifying  the customer details by taking the custom input from the user  into the database by calling modify method in the CustomerDaoDblImpl class
     */
    
    public static void modifyCustomerDetails()
    {
    	System.out.println("Please Enter the Customer Id for Modifying");
    	int id=Integer.parseInt(sc.nextLine());
         Customer obj=new Customer();
    	
    	System.out.println("Enter The First Name: ");
		String firstName = sc.nextLine();
		obj.setFirstName(firstName);
		firstName = obj.getFirstName();
		
		System.out.println("Enter The Last Name: ");
		String lastName = sc.nextLine();
		obj.setLastName(lastName);
		lastName = obj.getLastName();
		
		System.out.println("Enter The Gender: ");
		String gender = sc.nextLine();
		obj.setGender(gender);
		gender = obj.getGender();
		
		System.out.println("Enter The Age: ");
		int age = Integer.parseInt(sc.nextLine());
		obj.setAge(age);
		age = obj.getAge();
		
		
		
		System.out.println("Enter The Phone Number: ");
		long phoneNumber=Long.parseLong(sc.nextLine());
		obj.setPhoneNumber(phoneNumber);
		phoneNumber=obj.getPhoneNumber();
		
		System.out.println("Enter The Address: ");
		String address = sc.nextLine();
		obj.setAddress(address);
		address = obj.getAddress();
		
    	
    	if(dao.modify(id, obj))
    	{
    		List<Customer> li=dao.findCustomer(id);
    		System.out.println("Customer Details After Modifying");
    		System.out.println(li);
    	}
    }
    
    /*
     * method for deleting the customer details into the database by taking custom input as customer id from the user and then by calling delete method in the CustomerDaoDblImpl class
     */
    
    private static void deleteCustomer()
	{
		System.out.println("Please Enter The Customer Id For Deleting ");
		int id=Integer.parseInt(sc.nextLine());
		
		
		dao.delete(id);
		
	}
    
    /*
     * method for displaying  the customer details from the database by taking custom input as customer id from the user and then by calling findCustomer method in the CustomerDaoDblImpl class
     */
    
    
    private static void displayCustomer() throws SQLException {
    	System.out.println("\n Please Enter Your Customer Id");
    	int id=Integer.parseInt(sc.nextLine());
    	List<Customer> customer =dao.findCustomer(id);
		System.out.println(customer);
	}
    
    /*
     * method for displaying all  the customers details from the database   by calling findCustomer method in the CustomerDaoDblImpl class
     */
    
	private static void displayAllCustomers() {
		
		List<Customer> allCustomers = dao.findAll();
		for (Customer customer : allCustomers) {
			if (customer != null)
				System.out.println(customer);
		}
	}
	
	
	  /*
     * method for taking custom input from the user for appointment details
     */
	
    private static Appointment bookAppointment()
    {
    	Appointment appointment=new Appointment();
    	System.out.println("\n Please Enter The Customer Id");
    	int id=Integer.parseInt(sc.nextLine());
    	appointment.setCustomerId(id);
    	id=appointment.getCustomerId(); 
    	
    	System.out.println("\n Please Enter The Date of Appointment");
    	String date=sc.nextLine();
    	appointment.setDate(date);;
    	date=appointment.getDate(); 
    	
    	System.out.println("\n Please Enter The Time Of Appointment");
    	String time=sc.nextLine();
    	appointment.setTime(time);;
    	time=appointment.getTime(); 
    	
    	System.out.println("\n Please Enter The Customer PhoneNumber");
    	long phoneNumber=Long.parseLong(sc.nextLine());
    	appointment.setCustomerPhoneNumber(phoneNumber);;
    	phoneNumber=appointment.getCustomerPhoneNumber(); 
    	
    	System.out.println("\n Please Enter The Place Of Appointment");
    	String appointmentPlace=sc.nextLine();
    	appointment.setPlace(appointmentPlace);;
    	appointmentPlace=appointment.getPlace(); 
    	
    	return appointment;
    	
    	
    }
    
    
    private static AppointmentDao appointDao=new AppointmentDaoDbImpl();
    
    /*
     * method for adding the appointment details into the database by calling addAppointment method in the AppointmentDaoDblImpl class
     */
    
    public static void addAppointment() throws SQLException, SystemException
    {
    	Appointment createAppointment;
    	createAppointment=bookAppointment();
    	appointDao.add(createAppointment);
    	
    }
    
    /*
     * method for modifying  the appointment details into the database by taking the custom input from the user and then calling modifyAppointmentDetails method in AppointmentDaoDblImpl class
     */
    public static void modifyAppointmentDetails()
    {
    	System.out.println("Please Enter the Appointment Id for Modifying");
    	int id=Integer.parseInt(sc.nextLine());
         Appointment appointment=new Appointment();
    	
    	System.out.println("Enter The Date : ");
		String date = sc.nextLine();
		appointment.setDate(date);;
		date = appointment.getDate();
		
		System.out.println("\n Please Enter The Time Of Appointment");
    	String time=sc.nextLine();
    	appointment.setTime(time);;
    	time=appointment.getTime(); 
    	
    	System.out.println("\n Please Enter The Customer PhoneNumber");
    	long phoneNumber=Long.parseLong(sc.nextLine());
    	appointment.setCustomerPhoneNumber(phoneNumber);;
    	phoneNumber=appointment.getCustomerPhoneNumber(); 
    	
    	System.out.println("\n Please Enter The Place Of Appointment");
    	String appointmentPlace=sc.nextLine();
    	appointment.setPlace(appointmentPlace);;
    	appointmentPlace=appointment.getPlace(); 
    	
		
		
       if (appointDao.modify(id, appointment))
    	{
    		List<Appointment> li=appointDao.findAppointment(id);
    		System.out.println("Appointment Details After Modifying");
    		System.out.println(li);
    	}
    }

    /*
     * method for deleting the appointment details into the database by taking custom input as appointment id from the user and then by calling delete method in the AppointmentDaoDblImpl class
     */
    private static void deleteAppointment()
  	{
  		System.out.println("Please Enter The Appointment Id For Deleting ");
  		int id=Integer.parseInt(sc.nextLine());
  		
  		
  		appointDao.delete(id);
  		
  	}
    
    /*
     * method for displaying  the Appointment details from the database by taking custom input as appointment id from the user and then by calling findCustomer method in the CustomerDaoDblImpl class
     */
    
    private static void displayAppointment() throws SQLException {
    	System.out.println("\n Please Enter Your Appointment Id");
    	int id=Integer.parseInt(sc.nextLine());
    	List<Appointment> appointment =appointDao.findAppointment(id);
		System.out.println(appointment);
	}
    
    /*
     * method for displaying all  the appointment details from the database   by calling findAllAppointments method in the AppointmentDaoDblImpl class
     */
    
	private static void displayAllAppointments() {
		
		List<Appointment> allappointments = appointDao.findAllAppointments();
		for (Appointment appointment : allappointments) {
			if (appointment != null)
				System.out.println(appointment);
		}
	}
	
}
