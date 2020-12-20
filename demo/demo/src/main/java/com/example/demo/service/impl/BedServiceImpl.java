package com.example.demo.service.impl;

import com.example.demo.mapper.BedMapper;
import com.example.demo.service.IBedService;
import com.example.demo.model.Bed;
import com.example.demo.util.ResponseMessage.ResponseFailedMessage;
import com.example.demo.util.ResponseMessage.ResponseMessage;
import com.example.demo.util.ResponseMessage.ResponseOkMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BedServiceImpl implements IBedService {

    @Resource
    private BedMapper bedMapper;

    @Override
    public ResponseMessage getAll() {
        List res= bedMapper.getAll();
        return new ResponseMessage(1,res,"",bedMapper.getCount());
    }

    public ResponseMessage getById(int id){
        Bed res= (Bed) bedMapper.getById(id);
        if (res==null){
            return new ResponseFailedMessage("no such bed");
        }
        return new ResponseOkMessage(res,1);
    }

    public ResponseMessage getPage(int pageNum, int pageSize){
        List res= bedMapper.getPage((pageNum-1)*pageSize,pageSize);
        return new ResponseMessage(1,res,"",bedMapper.getCount());
    }

    public Boolean create(String roomNumber){
        Bed bed=new Bed();
        bed.setRoomNumber(roomNumber);
        return bedMapper.create(bed) != 0;
    }

    public Boolean use(int id){
        ResponseMessage res=getBedById(id);
        Bed bed= (Bed)res.data;
        if (bed==null)
            return false;
        bed.setBedStatus(1);
        return bedMapper.update(bed) == 1;
    }

    public ResponseMessage unuse(int id){
        ResponseMessage res=getBedById(id);
        Bed bed= (Bed)res.data;
        if (bed==null)
            return res;
        bed.setBedStatus(0);
        if (bedMapper.update(bed)==1){
            return new ResponseOkMessage(null,0);
        }else{
            return new ResponseFailedMessage("update failed");
        }
    }

    private ResponseMessage getBedById(int id) {
        Bed bed= (Bed) bedMapper.getById(id);
        if (bed==null)
            return new ResponseFailedMessage("not such bed");
        return new ResponseOkMessage(bed,1);
    }
}
