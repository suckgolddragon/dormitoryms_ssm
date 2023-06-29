package com.southwind.service;

import com.southwind.entity.DormitoryAdmin;

import java.util.List;

public interface DormitoryAdminService {
    public List<DormitoryAdmin> list();
    public List<DormitoryAdmin> search(String key,String value);
    public void save(DormitoryAdmin dormitoryAdmin);
    public void delete(Integer id);
    public void update(DormitoryAdmin dormitoryAdmin);
}
