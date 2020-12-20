package com.example.demo.service.impl;

import com.example.demo.mapper.CRUDMapper;
import com.example.demo.model.CRUDModel;
import com.example.demo.service.CRUDService;
import com.example.demo.util.Pager;
import com.example.demo.util.ResponseMessage.ResponseFailedMessage;
import com.example.demo.util.ResponseMessage.ResponseMessage;
import com.example.demo.util.ResponseMessage.ResponseOkMessage;
import javax.annotation.Resource;
import java.util.List;

public class CRUDServiceImpl implements CRUDService {
    @Resource
    CRUDMapper crudMapper;

    public CRUDServiceImpl() {
    }

    public ResponseMessage getAll() {
        List<CRUDModel> res=  crudMapper.getAll();
        return new ResponseMessage(1,res,null,res.size());
    }

    public ResponseMessage getPage(Pager pager){
        List<CRUDModel> res=crudMapper.getPage(pager.getOffset(),pager.getLimit());
        return new ResponseMessage(1,res,null,res.size());
    }

    public ResponseMessage create(CRUDModel t){
        if (crudMapper.getById(t.getId())!=null){
            return new ResponseFailedMessage("id already exists");
        }
        if (crudMapper.create(t)==0){
            return new ResponseFailedMessage("create failed");
        }
        return new ResponseOkMessage();
    }

    @Override
    public ResponseMessage delete(int id) {
        if (crudMapper.deleteById(id)==0){
            return new ResponseFailedMessage("delete by id failed");
        }
        return new ResponseOkMessage();
    }

    @Override
    public ResponseMessage update(CRUDModel crudModel) {
        if (crudMapper.getById(crudModel.getId())==null){
            return new ResponseFailedMessage("no such id");
        }
        if (crudMapper.update(crudModel)==0){
            return new ResponseFailedMessage("update failed");
        }else
            return new ResponseOkMessage();
    }
}
