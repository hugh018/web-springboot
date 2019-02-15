package hugh.tech.learn.tasks;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class DoTask {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("test1")
    public String test1() throws Exception {

        long start = System.currentTimeMillis();

        Future<Boolean> a = asyncTask.doTask11();
        Future<Boolean> b = asyncTask.doTask22();
        Future<Boolean> c = asyncTask.doTask33();

        while (!a.isDone() || !b.isDone() || !c.isDone()) {
            if (a.isDone() && b.isDone() && c.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();

        String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
        System.out.println(times);

        return times;
    }

    // ==test //
    @Autowired
    private Task task;

    @RequestMapping("/test2")
    public String test2() throws Exception {

        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();

        return "异步调用";
    }

    /**
     * 统计一下三个任务并发执行共耗时多少(三个任务都执行完毕即可)
     * 通过异步调用，让任务一、二、三并发执行，有效的减少了程序的总运行时间。
     *
     * @return
     * @throws Exception
     */
//    @RequestMapping("/test3")
//    public String test3() throws Exception {
//
//        long startTime = System.currentTimeMillis();
//
//        Future<String> t1 = task.doTaskOne();
//        Future<String> t2 = task.doTaskTwo();
//        Future<String> t3 = task.doTaskThree();
//
//        while (true) {
//            if (t1.isDone() && t2.isDone() && t3.isDone()) {
//                System.out.println("t1的异步调用返回结果： " + t1.get());
//                System.out.println("t2的异步调用返回结果： " + t2.get());
//                System.out.println("t3的异步调用返回结果： " + t3.get());
//                break;
//            }
//            Thread.sleep(1000);
//        }
//
//        return "全部任务完成，总耗时：" + (System.currentTimeMillis() - startTime) + " ms";
//    }

    /**
     * 使用自定义线程池进行异步调用
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/test4")
    public String test4() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
        Thread.currentThread().join();
        return "自定义线程池异步调用成功";
    }

    /**
     * 使用自定义线程池进行异步调用+获取返回结果及定义超时
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/test5")
    public String test5() throws Exception {
        Future<String> res = task.run();
        String ret = res.get(5, TimeUnit.SECONDS); // 超时异常
        return ret;
    }

}
