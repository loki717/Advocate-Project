package advocate.amdocs.dao;

import java.sql.SQLException;
import java.util.List;

import advocate.amdocs.entity.Appointment;

public interface AppointmentDao {
	boolean add(Appointment appointment) throws SQLException;

	List<Appointment> findAppointment(int id);

	List<Appointment> findAllAppointments();

	void delete(int id);

	boolean modify(int id, Appointment appointment);

}
