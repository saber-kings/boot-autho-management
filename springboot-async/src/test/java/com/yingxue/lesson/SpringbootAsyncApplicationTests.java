package com.yingxue.lesson;

import com.yingxue.lesson.task.AsyncTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Future;

@SpringBootTest
class SpringbootAsyncApplicationTests {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    void contextLoads() {
    }

    @Test
    void testTask() throws Exception {
//        asyncTask.doTaskOne();
//        asyncTask.doTaskTwo();
//        asyncTask.doTaskThree();
        Future<String> taskOne = asyncTask.doTaskOne();
        Future<String> taskTwo = asyncTask.doTaskTwo();
        Future<String> taskThree = asyncTask.doTaskThree();
        while (true){
            if (taskOne.isDone()&&taskTwo.isDone()&&taskThree.isDone()) {
                break;
            }
            Thread.sleep(10000);
        }
    }

}
