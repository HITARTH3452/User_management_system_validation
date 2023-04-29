package com.geekster.User.management.System.Controller;

import com.geekster.User.management.System.Service.UMSservice;
import com.geekster.User.management.System.models.UMS;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UMSController{

    @Autowired
    UMSservice umsService;

    @GetMapping(value = "/getAllUser")
    public List<UMS> getAlluser(){
        return umsService.getAllums();
    }

    @PostMapping(value = "/addUser")
    public String addUser(@Valid @RequestBody UMS ums){
       return umsService.adduser(ums);
    }

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    public UMS getUserById(@PathVariable String id){
        return umsService.getuserbasedOnId(id);
    }

    @DeleteMapping(value = "/deleteUserById/{id}")
    public String deleteUserById(@PathVariable String id){
        return umsService.removeUmsById(id);
    }

    @PutMapping(value = "/updateUserInfo/{id}")
    public String updateUserById(@PathVariable String id,@RequestBody UMS user){
        return umsService.updateUMSStatuById(id,user);
    }
}
