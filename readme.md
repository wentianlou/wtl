今天开始认真学习，认真总结。

定时任务介绍：
1、注解方法@Component,在方法上加@Scheduled(cron = "0 0/1 * * * ?")  每分钟执行1次改方法。
Spring Boot 创建定时任务：Spring Boot 默认已经实现了定时任务，只需要添加相应的注解即可完成。
pom.xml 文件配置：pom.xml 不需要添加其他依赖，只需要加入 Spring Boot 依赖即可。
在启动类上面加上 @EnableScheduling 注解
编写定时任务
启动 Spring Boot 项目在控制台就会看到任务定时执行

2、Timer 实现定时任务。可以实现一次定时任务或者循环任务。
Timer 是 JDK 实现的定时任务，用起来简单、方便，对一些简单的定时任务可以使用它。
由于它不支持 cron 表达式，现在已经很少用了。
Timer timer = new Timer();
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        System.out.println(111);
    }
}, 1000, 2000); // 1000毫米后执行第一次，之后每2000毫米执行一次
//终止任务
timer.concel();

3、Quartz 实现定时任务，Quartz 是一个完全由　Java 编写的开源作业调度框架，可以用它来实现定时任务。
在 pom.xml 文件添加 Quartz 依赖
编写 Job：定时执行的任务
编写 Task
在项目启动的时候调用 task 方法即可启动定时任务。

4、xxl-job 分布式任务调用