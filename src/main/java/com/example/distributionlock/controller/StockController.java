package com.example.distributionlock.controller;

import com.example.distributionlock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.example.distributionlock.controller
 * @ClassName: StockController
 * @Author: k.z
 * @CreateTime: 2022/10/8 18:23
 * @Description:
 */
@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("stock/deduct")
    public String deductBack(){
        stockService.deduct();
        return "库存扣减完成";
    }
}
