package com.example.demo.service;

import com.example.demo.model.CRUDModel;
import com.example.demo.util.Pager;
import com.example.demo.util.ResponseMessage.ResponseMessage;

public interface CRUDService{
    public ResponseMessage getAll();
    public ResponseMessage getPage(Pager pager);
    public ResponseMessage create(CRUDModel crudModel);
    public ResponseMessage delete(int id);
    public ResponseMessage update(CRUDModel crudModel);
}
