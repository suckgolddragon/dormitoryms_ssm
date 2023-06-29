package com.southwind.service.impl;

import com.southwind.entity.Moveout;
import com.southwind.entity.Student;
import com.southwind.mapper.DormitoryMapper;
import com.southwind.mapper.StudentMapper;
import com.southwind.service.StudentServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentServie {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<Student> list() {
        return this.studentMapper.list();
    }

    @Override
    public List<Student> search(String key, String value) {
        if(value.equals("")) return this.studentMapper.list();
        List<Student> list = null;
        switch (key){
            case "number":
                list = this.studentMapper.searchByNumber(value);
                break;
            case "name":
                list = this.studentMapper.searchByName(value);
                break;
        }
        return list;
    }

    @Override
    public void save(Student student) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        student.setCreateDate(format.format(date));
        try {
            this.studentMapper.save(student);
            this.dormitoryMapper.subAvailable(student.getDormitoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        try {
            this.studentMapper.update(student);
            if(!student.getDormitoryId().equals(student.getOldDormitoryId())){
                this.dormitoryMapper.subAvailable(student.getDormitoryId());
                this.dormitoryMapper.addAvailable(student.getOldDormitoryId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Student student) {
        try {
            this.studentMapper.delete(student.getId());
            this.dormitoryMapper.addAvailable(student.getDormitoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> moveoutList() {
        return this.studentMapper.moveoutList();
    }

    @Override
    public List<Student> searchForMoveoutList(String key, String value) {
        if(value.equals("")) return this.studentMapper.moveoutList();
        List<Student> list = null;
        switch (key){
            case "number":
                list = this.studentMapper.searchForMoveoutByNumber(value);
                break;
            case "name":
                list = this.studentMapper.searchForMoveoutByName(value);
                break;
        }
        return list;
    }

    @Override
    public void moveout(Moveout moveout) {
        try {
            this.dormitoryMapper.addAvailable(moveout.getDormitoryId());
            this.studentMapper.updateStateById(moveout.getStudentId());
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            moveout.setCreateDate(format.format(date));
            this.studentMapper.moveout(moveout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> findByDormitoryId(Integer dormitoryId) {
        return this.studentMapper.findByDormitoryId(dormitoryId);
    }
}
