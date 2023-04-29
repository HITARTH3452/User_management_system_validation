package com.geekster.User.management.System.Repository;

import com.geekster.User.management.System.models.UMS;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UMSDao {
    private List<UMS> umslist;

    public UMSDao(){
        umslist = new ArrayList<>();
    }

    public List<UMS> getUmsfromdataSources(){
        return umslist;
    }

    public boolean save(UMS ums){
        umslist.add(ums);
        return true;
    }

    public boolean remove(UMS ums){
        umslist.remove(ums);
        return true;
    }

    public Boolean updateUserById(String userid, UMS user) {
        for ( UMS userObj : umslist ) {
            if ( userObj.getUserId().equals(userid) ) {
                userObj.setUserId(user.getUserId());
                userObj.setUserName(user.getUserName());
                userObj.setEmail(user.getEmail());
                userObj.setPhone_Number(user.getPhone_Number());
                userObj.setDate(user.getDate());
                userObj.setTime(user.getTime());
                userObj.setDob(user.getDob());
                return true;
            }
        }
        return false;
    }
}
