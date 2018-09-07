package org.lwt.service;

import java.util.List;

import org.lwt.entity.Departments;

public interface DepartmentsService {
  List<Departments> selectAll();
  Departments getOne();
}
