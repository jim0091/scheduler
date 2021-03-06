package com.jinhui.scheduler.data.core.mapper.imiqian;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TradeIdSequenceMapper {

    /**
     * 如果数据库中没有该条记录，就插入一条新的，有则在原记录上加一
     * @param seqKey
     */
    @Update(value = "INSERT INTO trade_id_sequence (seq_key, seq) VALUES(#{seqKey}, 1) ON DUPLICATE KEY UPDATE seq=seq+1")
    void insertOrUpdateByKey(@Param("seqKey") String seqKey);


    @Select(value = "SELECT seq FROM trade_id_sequence where seq_key = #{seqKey}")
    long querySeqByKey(@Param("seqKey") String seqKey);

}