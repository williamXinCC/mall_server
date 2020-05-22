package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamSysNotice;
import com.william.pojo.WilliamSysNoticeExample;
import org.apache.ibatis.annotations.Param;

public interface WilliamSysNoticeMapper {
    int countByExample(WilliamSysNoticeExample example);

    int deleteByExample(WilliamSysNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WilliamSysNotice record);

    int insertSelective(WilliamSysNotice record);

    List<WilliamSysNotice> selectByExample(WilliamSysNoticeExample example);

    WilliamSysNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WilliamSysNotice record, @Param("example") WilliamSysNoticeExample example);

    int updateByExample(@Param("record") WilliamSysNotice record, @Param("example") WilliamSysNoticeExample example);

    int updateByPrimaryKeySelective(WilliamSysNotice record);

    int updateByPrimaryKey(WilliamSysNotice record);

    List<WilliamSysNotice> selectPage(WilliamSysNoticeExample example);
}