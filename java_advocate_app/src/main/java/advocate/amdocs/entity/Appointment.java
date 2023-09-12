package advocate.amdocs.entity;

public class Appointment {
	private int appointmentId;
	private int customerId;
	private String date;
	private String time;
	private long customerPhoneNumber;
	private String place;
	public int getCustomerId() {
		return customerId;
	}
	
	
	public int getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public long getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(long customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}


	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", customerId=" + customerId + ", date=" + date
				+ ", time=" + time + ", customerPhoneNumber=" + customerPhoneNumber + ", place=" + place + "]";
	}

	
	

}
