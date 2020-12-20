package com.example.demo.controller;

import com.example.demo.service.IBedService;
import com.example.demo.util.ResponseMessage.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/bed")
@CrossOrigin("*")
public class BedController {
    @Resource
    private IBedService bedService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseMessage create(@RequestParam("roomNumber")String roomNumber){
        Boolean res= bedService.create(roomNumber);
        ResponseMessage responseMessage=new ResponseMessage();
        if (res){
            responseMessage.setStatus(1);
        }else{
            responseMessage.setStatus(0);
        }
        return responseMessage;
    }

    @RequestMapping(value = "/getPage",method = RequestMethod.GET)
    public ResponseMessage getPage(@RequestParam("pageNum")Integer pageNum,
                                  @RequestParam("pageSize")Integer pageSize){
        return  bedService.getPage(pageNum,pageSize);
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseMessage getAll(){
        return  bedService.getAll();
    }

    @RequestMapping(value = "/use",method = RequestMethod.PUT)
    public ResponseMessage use(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        String roomNumber=request.getParameter("roomNumber"),
               customerNumber=request.getParameter("customerNumber");
        ResponseMessage responseMessage=new ResponseMessage();
        Boolean res=bedService.use(id);
        if (res){
            responseMessage.setStatus(1);
        }else{
            responseMessage.setStatus(0);
        }
        return responseMessage;
    }
}
