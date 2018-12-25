# socket java通信

- 介绍：
   ServerSocket的 accept()是一个阻塞式的方法

- 注意：

    ```
    无论server端还是client端，在向输出流中写数据的时候都需要加上换行符"\n",
    否则flush()刷新也没用，😄操蛋。
    ```


    