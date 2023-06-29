package com.southwind.service;

import com.southwind.entity.Moveout;
import com.southwind.entity.Student;

import java.util.List;

public interface StudentServie {
    public List<Student> list();
    public List<Student> search(String key,String value);
    public void save(Student student);
    public void update(Student student);
    public void delete(Student student);
    public List<Student> moveoutList();
    public List<Student> searchForMoveoutList(String key,String value);
    public void moveout(Moveout moveout);
    public List<Student> findByDormitoryId(Integer dormitoryId);
}
