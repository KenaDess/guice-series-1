package com.discursive.example.student.register;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.discursive.example.student.Registrar;
import com.discursive.example.student.Student;
import com.discursive.example.student.StudentStore;
import com.discursive.example.student.store.*;

@Singleton
public class LenientRegistrar implements Registrar {
	
	//------- with Injection 
	private final StudentStore studentStore;
	//------- Without Injection
	//private final DummyStudentStore studentStore;
	
	@Inject
	public LenientRegistrar(StudentStore studentStore) {
		//------- Injection 
		this.studentStore = studentStore;
		//------- Without Injection
		//this.studentStore = new DummyStudentStore();
	}

	public boolean checkStudentStatus(Integer studentId) {
		boolean status = false;
		
		Student student = studentStore.load( studentId );
	
		if( student != null && student.getCredits() != null ) {
			status = student.getCredits() >= 10.0;	
		}
		return status;		
	}

	public Student registerStudent(String name, Integer credits) {
		Student s = new Student();
		s.setName( name );
		s.setCredits( credits );
		return studentStore.save( s );
	}

}
