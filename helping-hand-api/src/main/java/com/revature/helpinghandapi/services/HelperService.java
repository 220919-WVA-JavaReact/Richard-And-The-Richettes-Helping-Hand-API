package com.revature.helpinghandapi.services;


import com.revature.helpinghandapi.dto.Credentials;
import com.revature.helpinghandapi.dto.HelperDTO;
import com.revature.helpinghandapi.entities.Helper;
import com.revature.helpinghandapi.repositories.HelperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelperService {
    private HelperRepository hr;

    @Autowired
    public HelperService(HelperRepository hr){
        this.hr = hr;
    }

    public HelperDTO createHelper(Credentials cred){
        if(hr.getHelperByUsername(cred.getUsername()).isPresent()){

        }
        Helper newHelper = new Helper();
        newHelper.setFirst(cred.getFirst());
        newHelper.setLast(cred.getLast());
        newHelper.setUsername(cred.getUsername());
        newHelper.setPassword(cred.getPassword());
        return new HelperDTO(hr.save(newHelper));
    }
}
