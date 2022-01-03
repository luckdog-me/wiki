package com.jiawa.wiki.service;

import com.jiawa.wiki.domain.Test;
import com.jiawa.wiki.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: jie
 * @Date: 2022/1/3 14:02
 * @Description:
 */

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> list(){
        return testMapper.list();
    }
}
