package com.example.distributionlock.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.distributionlock.mapper.StockMapper;
import com.example.distributionlock.pojo.Stock;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: com.example.distributionlock.service
 * @ClassName: StockService
 * @Author: k.z
 * @CreateTime: 2022/10/8 17:51
 * @Description:
 */
@Service
//@Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StockService {

//    private Stock stock = new Stock();

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ReentrantLock reentrantLock = new ReentrantLock();

    @Autowired
    private StockMapper stockMapper;

    // 扣减库存的方法
//    public synchronized void deduct(){
//        stock.setStock(stock.getStock()-1);
//        System.out.println("剩余可用库存为："+stock.getStock());
//    }

//    public void deduct(){
//        reentrantLock.lock();
//        try {
//            stock.setStock(stock.getStock()-1);
//            System.out.println("剩余可用库存为："+stock.getStock());
//        } finally {
//            reentrantLock.unlock();
//        }
//
//    }

//    public void deduct(){
//        reentrantLock.lock();
//        try {
//            // 1、查询数据库中可用库存数量
//            Stock stock = stockMapper.selectOne(new QueryWrapper<Stock>().eq("product_code","1001"));
//            if(!Objects.isNull(stock)&&stock.getCount()>0){
//                stock.setCount(stock.getCount()-1);
//                // 2、扣减库存
//                stockMapper.updateById(stock);
//            }
//        } finally {
//            reentrantLock.unlock();
//        }
//
////            System.out.println("剩余可用库存为："+stock.getStock());
//
//    }

//    public void deduct(){
//
//        stockMapper.updateStock("1001",1);
//
//    }

//    public void deduct(){
//
//        stringRedisTemplate.execute(new SessionCallback<Object>() {
//            @Override
//            public Object execute(RedisOperations operations) throws DataAccessException {
//
//                operations.watch("stock");
//                //1、查询缓存中的库存
//                String stock = (String) operations.opsForValue().get("stock");
//                //2、判断是否充足
//                if (!Objects.isNull(stock)){
//                    Integer integer = Integer.valueOf(stock);
//                    if(integer>0){
//                        operations.multi();
//                        //3、扣减库存
//                        operations.opsForValue().set("stock",String.valueOf(--integer));
//                        List exec = operations.exec();
//                        if (exec==null||exec.isEmpty()){
//                            try {
//                                Thread.sleep(20);
//                            } catch (InterruptedException e) {
//                                throw new RuntimeException(e);
//                            }
//                            deduct();
//                        }
//                        return exec;
//                    }
//                }
//
//                return null;
//            }
//        });
//
//    }

    public void deduct(){

        String uuid = UUID.randomUUID().toString();

        //循环加锁
        while (!stringRedisTemplate.opsForValue().setIfAbsent("lock", uuid,30,TimeUnit.SECONDS)){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {

            // stringRedisTemplate.expire("stock",3, TimeUnit.SECONDS);

            //1、查询缓存中的库存
            String stock = (String) stringRedisTemplate.opsForValue().get("stock");
            //2、判断是否充足
            if (!Objects.isNull(stock)&&stock.length()>0){
                Integer integer = Integer.valueOf(stock);
                if(integer>0){
                    //3、扣减库存
                    stringRedisTemplate.opsForValue().set("stock",String.valueOf(--integer));
                }
            }


        } finally {

            // 解锁 需要先判断是否是当前uuid
            if(StringUtils.equals(stringRedisTemplate.opsForValue().get("stock"),uuid)){
                stringRedisTemplate.delete("lock");
            }

        }


    }

}
