package com.william.mall_server.mapper;

import java.util.List;

import com.william.pojo.WilliamPicture;
import com.william.pojo.WilliamPictureExample;
import com.william.pojo.resp.HomePageAdvResp;
import org.apache.ibatis.annotations.Param;

public interface WilliamPictureMapper {
    int countByExample(WilliamPictureExample example);

    int deleteByExample(WilliamPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WilliamPicture record);

    int insertSelective(WilliamPicture record);

    List<WilliamPicture> selectByExample(WilliamPictureExample example);

    WilliamPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WilliamPicture record, @Param("example") WilliamPictureExample example);

    int updateByExample(@Param("record") WilliamPicture record, @Param("example") WilliamPictureExample example);

    int updateByPrimaryKeySelective(WilliamPicture record);

    int updateByPrimaryKey(WilliamPicture record);

    List<WilliamPicture> selectPage(WilliamPictureExample example);

    List<WilliamPicture> getHomePageAdv(@Param("tenantId") String tenantId,@Param("client") String client);
}