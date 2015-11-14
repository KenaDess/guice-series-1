package com.discursive.example.student.register;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.discursive.example.student.Registrar;
import com.discursive.example.student.Student;
import com.discursive.example.student.StudentStore;
import com.discursive.example.student.exemple.ExempleItf;

@Singleton
public class LenientRegistrar implements Registrar {

  private final StudentStore studentStore;
  @Inject
  private StudentStore exempleRemplacement;
  @Inject
  private String exempleRemplacement2;
  @Inject
  private ExempleItf exempleRemplacement3;

  // ------- Injection
  @Inject
  public LenientRegistrar(StudentStore studentStore, String x) {
    this.studentStore = studentStore;
    this.exempleRemplacement2 = x;
  }

  // ------- Without Injection
  // public LenientRegistrar() {
  // this.studentStore = new DummyStudentStore();
  // }

  public boolean checkStudentStatus(Integer studentId) {
    boolean status = false;

    Student student = studentStore.load(studentId);

    if (student != null && student.getCredits() != null) {
      status = student.getCredits() >= 10.0;
    }
    return status;
  }

  public Student registerStudent(String name, Integer credits) {
    Student s = new Student();
    s.setName(name);
    s.setCredits(credits);
    return studentStore.save(s);
  }

}
