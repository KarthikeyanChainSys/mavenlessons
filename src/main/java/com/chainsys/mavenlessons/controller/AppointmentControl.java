package com.chainsys.mavenlessons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import com.chainsys.mavenlessons.entity.Appointment;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.AppointmentRepository;

@RestController
public class AppointmentControl {
	@Autowired
	private AppointmentRepository apprepo;
	
	@PostMapping(value = "/newappointment", consumes = "application/json")
	public RedirectView addAppointment(@RequestBody Appointment app)
	{
		apprepo.save(app);
		return new RedirectView("Add new appointment");
	}
	
	@PostMapping(value = "/modifyappointment", consumes = "application/json")
	public RedirectView modifyAppointment(@RequestBody Appointment app)
	{
		apprepo.save(app);
		return new RedirectView("Update appointment");
	}

	@GetMapping(value = "/getappointment")
	public Appointment getAppointmentById(int id) {
		return apprepo.findById(id);
	}
	
	@GetMapping( value = "/getallappointments")
	public List<Appointment> getAllAppointments(){
		return apprepo.findAll();
	}
	
	@GetMapping(value = "/getdoctorbyappointmentid")
	public String getDoctorByAppointmentId(int id) {
		Appointment app = apprepo.findById(id);
		Doctor doc = app.getDoctor();
		return doc.toString();
	}
	
//	@GetMapping(value = "/getappointmentbydoctor") 
//	public List<Appointment> getAppointmentByDocId(int id) { 
//		return apprepo.findAllByDoctorId(id);
//	}
	
	@DeleteMapping(value = "/deleteappointment")
	public RedirectView deleteAppointment(int id) {
		apprepo.deleteById(id);
		return new RedirectView("Delete appointment");
		
	}
}
