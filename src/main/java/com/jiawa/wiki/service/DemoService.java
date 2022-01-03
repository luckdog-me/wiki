package com.jiawa.wiki.service;

import com.jiawa.wiki.domain.Demo;
import org.springframework.stereotype.Service;
import com.jiawa.wiki.mapper.DemoMapper;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: jie
 * @Date: 2022/1/3 14:02
 * @Description:
 */

@Service
public class DemoService {

    @Resource
    private DemoMapper DemoMapper;

    public List<Demo> list(){
        return DemoMapper.selectByExample(null);
    }
}
