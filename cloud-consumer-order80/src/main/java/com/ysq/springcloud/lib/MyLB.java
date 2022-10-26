package com.ysq.springcloud.lib;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述
 *
 * @author 闫思晴
 * @date 2022/10/09  15:21
 */
@Component
public class MyLB implements LoadBalancer{
    private AtomicInteger atomicInteger=new AtomicInteger(0);//AtomicInteger可以同时被多个线程使用.

    /**
     *获取访问次数
     * @return
     */
    public final  int getAndIncrement(){
        int current;
        int next;
        do {
            current=this.atomicInteger.get();   //初始值为0
            next=current>Integer.MAX_VALUE ? 0:current+1; //不大于xx时，下一次的值为current+1
        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("第几次访问次数next:"+next);
        return next;
    }

    /**
     * 获取服务器集合中对应的坐标。
     * @param serviceInstanceList
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();//访问次数  %  服务器总数
        return serviceInstanceList.get(index);  //返回对应下标的服务器
    }
}
