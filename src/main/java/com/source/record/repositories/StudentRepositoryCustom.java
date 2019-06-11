package com.source.record.repositories;

import com.source.record.entities.Student;

public interface StudentRepositoryCustom {

	public Student saveAndLog(Student student);
}
