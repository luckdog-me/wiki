package com.jiawa.wiki.mapper;

import com.jiawa.wiki.domain.Doc;
import com.jiawa.wiki.domain.DocExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocMapper {
    long countByExample(DocExample example);

    int deleteByExample(DocExample example);

    int insert(Doc record);

    int insertSelective(Doc record);

    List<Doc> selectByExample(DocExample example);

    int updateByExampleSelective(@Param("record") Doc record, @Param("example") DocExample example);

    int updateByExample(@Param("record") Doc record, @Param("example") DocExample example);
}