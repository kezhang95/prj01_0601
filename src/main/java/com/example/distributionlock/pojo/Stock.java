package com.example.distributionlock.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Package: com.example.distributionlock.pojo
 * @ClassName: Stock
 * @Author: k.z
 * @CreateTime: 2022/10/8 17:48
 * @Description:
 */
@Data
@TableName("t_stock")
public class Stock {

//    private Integer stock = 5000;

    private Long id;
    private String productCode;
    private String warehouse;
    private Integer count;
}
