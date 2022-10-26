package com.ysq.springloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/10/11  11:08
 */
@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+"    paymentInfo_ok  "+id+"\t"+"Ok";
    }
//--------服务降级----------
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")//设置红线，当相应时间超过3000时，执行paymentInfo_TimeoutHandler方法
    })  //当出异常时，调用paymentInfo_TimeoutHandler方法来兜底
    public String paymentInfo_Timeout(Integer id){
        //int age=10/0;         //异常时也会调用paymentInfo_TimeoutHandler方法
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_Timeout,id"+id+"\tok";
    }

    /**
     * 作为paymentInfo_Timeout方法异常时的兜底方法，即fallbackMethod
     * @param id
     * @return
     */
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_Timeout,id"+id+"\tnonono";    }

    //-------------服务熔断-------------
    @HystrixCommand(fallbackMethod = "FallBackMethod",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),//是否开启熔断器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间窗口期（当服务熔断后，时间窗口期内，认为是断开状态，窗口期过后，熔断器为半开状态，当有正确的请求时，熔断器闭合）
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60"),//失败率达到多少后跳闸
    })
    public String paymentCiruitBreaker(Integer id) {
        if (id<0){
            throw new RuntimeException("*******id不能为负数");       //触发服务降级
        }
        String s = IdUtil.simpleUUID();     //生成随机字符串
        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+s;
    }

    /**
     * 服务熔断的降级方法
     * @param id
     * @return
     */
    public String FallBackMethod(Integer id){
        return "id不能为负数,请稍后再试,id:"+id;
    }
}
