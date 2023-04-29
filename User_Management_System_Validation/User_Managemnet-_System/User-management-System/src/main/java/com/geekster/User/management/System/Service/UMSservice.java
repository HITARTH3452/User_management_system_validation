package com.geekster.User.management.System.Service;

import com.geekster.User.management.System.Repository.UMSDao;
import com.geekster.User.management.System.models.UMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class UMSservice {
     List<UMS> umslist;

     @Autowired
     UMSDao umsrepo;

     public List<UMS> getAllums(){
         return umsrepo.getUmsfromdataSources();
     }

    public UMS getuserbasedOnId(String id) {
        List<UMS> umsListRightNow = umsrepo.getUmsfromdataSources();

        for (UMS ums : umsListRightNow) {
            if (ums.getUserId().equals(id)) {
                return ums;
            }
        }
        return null;
    }

     public String adduser(UMS ums){
         boolean insertionStatus = umsrepo.save(ums);
         if (insertionStatus) {
             return "ums added successfully!!!!";
         } else {
             return "Failed!!!.....ums Not Possible";
         }
     }

    public String removeUmsById(String id) {
        String status;
        boolean deleteRespone = false;
        if (id != null) {
            List<UMS> todoListRightNow = umsrepo.getUmsfromdataSources();

            for (UMS ums : todoListRightNow) {
                if (ums.getUserId().equals(id)) {
                    deleteRespone = umsrepo.remove(ums);
                    if(deleteRespone) {
                        status = "ums with id " + id + " was deleted!!";
                    } else {
                        status = "ums with id " + id + " was not deleted!!!...Database error";
                    }
                    return status;
                }
            }
            return "ums with id " + id + " Does not exists";
        }else{
            return "Invalid ums .....Cannot accept NUll ID!!";
        }
    }

    public String updateUMSStatuById(String id, UMS user) {
        boolean updateStatus = umsrepo.updateUserById(id,user);

        if(updateStatus){
            return "ums with id: " + id + " was updated";
        }else{
            return "ums with id: " + id + "was not updated!!!";
        }
    }

//    public String updateUMS(String id, String Name, String phone_Number){
//         UMS user = umsrepo.findById(id);
//    }
}
