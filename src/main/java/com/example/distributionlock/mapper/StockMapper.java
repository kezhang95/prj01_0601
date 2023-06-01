package com.example.distributionlock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.distributionlock.pojo.Stock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @Package: com.example.distributionlock.mapper
 * @ClassName: StockMapper
 * @Author: k.z
 * @CreateTime: 2022/10/8 19:50
 * @Description:
 */
public interface StockMapper extends BaseMapper<Stock> {
    @Update("update t_stock set count = count - #{count} where product_code = #{productCode} and count >= #{count}")
    int updateStock(@Param("productCode") String productCode, @Param("count") Integer count);
}
