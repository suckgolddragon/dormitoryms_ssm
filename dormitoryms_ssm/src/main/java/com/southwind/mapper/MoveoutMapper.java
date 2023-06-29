package com.southwind.mapper;

import com.southwind.entity.Moveout;

import java.util.List;

public interface MoveoutMapper {
    public List<Moveout> list();
    public List<Moveout> searchByStudentName(String value);
    public List<Moveout> searchByDormitoryName(String value);
}
