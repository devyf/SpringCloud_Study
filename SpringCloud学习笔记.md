## 1.微服务概述：

。微服务(Microservices)：就目前而言，对于微服务业界并没有一个统一的、标准的定义（While there is no precise definition of this architectural style）。

![image-20210401223844245](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401223844245.png)

总结：

从技术维度理解：微服务化的核心就是将传统的一站式应用，根据业务拆分成一个一个的服务，彻底地去耦合，每一个微服务提供单个业务功能的服务，一个服务做一件事，从技术角度看就是一种小而独立的处理过程，类似进程的概念，能够自行单独启动或销毁，拥有自己独立的数据库。

![image-20210401231704718](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401231704718.png)



## 2.微服务架构：

强调的是服务的大小，它关注的是某一个点，是具体解决某一个问题/提供落地对应服务的一个服务应用，狭义地看，可以看做IDEA（Elcipse）里面用maven开发的一个个独立的小的Module，它具体是使用Springboot开发的一个小模块，一个模块就做一件事情。

强调的是一个个的个体，每个个体完成一个具体的任务或者功能。

![image-20210401232747891](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401232747891.png)

### 2.1.微服务的优缺点

优点：

![image-20210401233638261](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401233638261.png)

缺点：

![image-20210401233937173](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401233937173.png)

### 2.2.微服务的技术框架

![image-20210401235212016](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401235212016.png)

![image-20210402001529449](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210402001529449.png)

### 2.3.各微服务框架对比：

![image-20210402003256933](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210402003256933.png)

![image-20210402003318119](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210402003318119.png)



总结：

![image-20210402004520817](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210402004520817.png)

> 阳哥总结：Springcloud是分布式微服务架构下的一站式解决方案，是各个微服务架构落地技术的集合体，俗称微服务全家桶

### 2.4.Springcloud和SpringBoot是什么关系？

![image-20210402005123956](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210402005123956.png)

### 2.5.Springcloud与Dubbo技术选型对比

![image-20210402011526466](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210402011526466.png)

![image-20210402011616425](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210402011616425.png)

![image-20210402011753435](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210402011753435.png)

![image-20210402011848950](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210402011848950.png)

### 2.6.SpringCloud功能介绍

![image-20210402020116867](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210402020116867.png)





## Eureka服务注册与发现

![image-20210331233609040](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210331233609040.png)



![image-20210331234714123](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210331234714123.png)



![image-20210331234912380](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210331234912380.png)



## Eureka的自我保护机制

![image-20210401111859000](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401111859000.png)

## Eureka比Zookeeper好在哪里？

![image-20210402182930644](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210402182930644.png)

![image-20210402184320894](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210402184320894.png)



## Ribbon

![image-20210401120229103](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401120229103.png)



## Feign负载均衡

![image-20210401132615808](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401132615808.png)



## Hystrix

https://github.com/Netflix/Hystrix/wiki

![image-20210401141448486](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401141448486.png)

![image-20210404134359078](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210404134359078.png)



### 服务熔断

![image-20210404134520636](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210404134520636.png)



## Zuul路由网关

![image-20210404203324492](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210404203324492.png)



## SpringCloud Config

![image-20210405144627887](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210405144627887.png)

![image-20210405145517432](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210405145517432.png)

![image-20210405145117441](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210405145117441.png)

![image-20210405145208596](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210405145208596.png)

![image-20210405145238448](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210405145238448.png)



## 总结学习路线

![image-20210401191211585](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401191211585.png)



![image-20210401191401883](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401191401883.png)



![image-20210401191423739](C:\Users\huang\AppData\Roaming\Typora\typora-user-images\image-20210401191423739.png)