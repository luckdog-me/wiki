package com.jiawa.wiki.service;

import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: jie
 * @Date: 2022/1/3 14:02
 * @Description:
 */

@Service
public class EbookService {

    @Resource
    private EbookMapper EbookMapper;

    public List<Ebook> list(){
        return EbookMapper.selectByExample(null);
    }
}
