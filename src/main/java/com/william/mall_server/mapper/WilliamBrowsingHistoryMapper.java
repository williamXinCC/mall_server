package com.william.mall_server.mapper;

import com.william.pojo.WilliamBrowsingHistory;
import com.william.pojo.WilliamBrowsingHistoryExample;
import com.william.pojo.resp.BrowsingHisResp;
import com.william.pojo.resp.BrowsingHisVo;
import com.william.pojo.resp.FootmarkResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WilliamBrowsingHistoryMapper {
    int countByExample(WilliamBrowsingHistoryExample example);

    int deleteByExample(WilliamBrowsingHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WilliamBrowsingHistory record);

    int insertSelective(WilliamBrowsingHistory record);

    List<WilliamBrowsingHistory> selectByExample(WilliamBrowsingHistoryExample example);

    WilliamBrowsingHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WilliamBrowsingHistory record, @Param("example") WilliamBrowsingHistoryExample example);

    int updateByExample(@Param("record") WilliamBrowsingHistory record, @Param("example") WilliamBrowsingHistoryExample example);

    int updateByPrimaryKeySelective(WilliamBrowsingHistory record);

    int updateByPrimaryKey(WilliamBrowsingHistory record);

    List<WilliamBrowsingHistory> selectPage(WilliamBrowsingHistoryExample example);

    // uid查询足迹
    List<BrowsingHisResp> getBrowsingHisByUid(String uid);

    // 保存浏览商品记录
    Integer saveAndSelect(WilliamBrowsingHistory williamBrowsingHistory);

    // 增加浏览次数
    void updateCount(WilliamBrowsingHistory williamBrowsingHistory);

    // 日期时间 查询足迹
    List<BrowsingHisResp> getBrowsingHisByUidAndDayTime(@Param("uid") String uid,@Param("dayTime") String dayTime);

    List<FootmarkResp> getFootmarkByUid(String uid);
}