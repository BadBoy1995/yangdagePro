package com.yangdage.service;

import com.yangdage.dao.TUserMapper;
import com.yangdage.model.TUser;
import com.yangdage.model.TUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserService {
    @Autowired
    TUserMapper tUserMapper;
    public List<TUser> selectByExample(TUserExample tUserExample){
        return tUserMapper.selectByExample(tUserExample);
    }
}
