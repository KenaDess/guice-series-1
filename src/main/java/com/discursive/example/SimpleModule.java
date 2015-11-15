package com.discursive.example;

import com.discursive.example.student.Registrar;
import com.discursive.example.student.Student;
import com.discursive.example.student.StudentStore;
import com.discursive.example.student.exemple.ExempleImpl;
import com.discursive.example.student.exemple.ExempleItf;
import com.discursive.example.student.register.LenientRegistrar;
import com.discursive.example.student.store.DummyStudentStore;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class SimpleModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(StudentStore.class).toInstance(gtClass());
    bind(Registrar.class).to(LenientRegistrar.class);
    bind(String.class).toInstance("Test");
    bind(ExempleItf.class).toInstance(getExempleInstance());
  }

  public DummyStudentStore gtClass() {
    return new DummyStudentStore();
  }

  public ExempleImpl getExempleInstance() {
    return new ExempleImpl();
  }
}
