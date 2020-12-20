package com.example.demo.service;

import com.example.demo.util.ResponseMessage.ResponseMessage;
import org.apache.ibatis.annotations.Param;

public interface IBedService {
    public ResponseMessage getPage(int pageNum, int pageSize);
    public Boolean create(String roomNumber);
    public Boolean use(int id);
    public ResponseMessage unuse(@Param("id") int id);
    public ResponseMessage getById(int id);
    ResponseMessage getAll();
}
