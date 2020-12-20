package com.example.demo.mapper;

import com.example.demo.model.Bed;
import com.example.demo.model.CRUDModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CRUDMapper {
    public List<CRUDModel> getAll();
    public List<CRUDModel> getPage(@Param("offset") int offset,@Param("limit") int limit);
    public int create(CRUDModel crudModel);
    public int update(CRUDModel crudModel);
    public CRUDModel getById(int id);
    public int deleteById(int id);
    public int getCount();
}
