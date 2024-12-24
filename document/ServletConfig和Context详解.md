## ServletConfig

- ServletConfig的含义
    - Servlet对象的配置信息对象
    - ServletConfig对象中封装了&lt;servlet&gt;&lt;/servlet&gt;标签中的配置信息（web.xml文件中servlet的配置信息）

   - 一个Servlet对应一个ServletConfig对象
   - Servlet对象是Tomcat服务器创建，并且ServletConfig对象也是Tomcat服务器创建。并且默认情况下，他们都是在用户发送第一次请求的时候创建
   -  Tomcat服务器调用Servlet对象的init方法的时候需要传一个ServletConfig对象的参数给init方法
   - ServletConfig接口的实现类是Tomcat服务器给实现的
   - 

- ServletConfig接口的常用的方法

- ```java
        public String getInitParameter(String name); // 通过初始化参数的name获取value
        public Enumeration<String> getInitParameterNames(); // 获取所有的初始化参数的name
        public ServletContext getServletContext(); // 获取ServletContext对象
        public String getServletName(); // 获取Servlet的name
   ```

## ServletContext

- 一个Servlet对象对应一个ServletConfig
- 只要在同一个webapp当中，只要在同一个应用当中，所有的Servlet对象都是共享同一个ServletContext对象的
- ServletContext对象在服务器启动阶段创建，在服务器关闭的时候销毁。这就是ServletContext对象的生命周期。ServletContext对象是应用级对象
- Tomcat服务器中有一个webapps，这个webapps下可以存放webapp，可以存放多个webapp，假设有100个webapp，那么就有100个ServletContext对象。
- 但是一个应用，一个webapp只有一个ServletContext对象
- ServletContext被称为Servlet上下文对象
- 一个ServletContext对象通常对应的是一个web.xml文件
- 
- ServletContext对应显示生活中的什么例子呢？

  - 一个教室里有多个学生，那么每一个学生就是一个Servlet，这些学生都在同一个教室当中，那么我们可以把这个教室叫做ServletContext对象。那么也就是说放在这个ServletContext对象（环境）当中的数据，在同一个教室当中，物品都是共享的。比如：教室中有一个空调，所有的学生都可以操作。可见，空调是共享的。因为空调放在教室当中。教室就是ServletContext对象。

- ServletContext是一个接口，Tomcat服务器对ServletContext接口进行了实现。
  - ServletContext对象的创建也是Tomcat服务器来完成的。启动webapp的时候创建的。

- ServletContext接口中有哪些常用的方法？

  - ```java
        public String getInitParameter(String name); // 通过初始化参数的name获取value
        public Enumeration<String> getInitParameterNames(); // 获取所有的初始化参数的name
    ```

  - ```xml
    <!--以上两个方法是ServletContext对象的方法，这个方法获取的是什么信息？是以下的配置信息-->
    <context-param>
        <param-name>pageSize</param-name>
        <param-value>10</param-value>
    </context-param>
    <context-param>
        <param-name>startIndex</param-name>
        <param-value>0</param-value>
    </context-param>
    <!--注意：以上的配置信息属于应用级的配置信息，一般一个项目中共享的配置信息会放到以上的标签当中。-->
    <!--如果你的配置信息只是想给某一个servlet作为参考，那么你配置到servlet标签当中即可，使用ServletConfig对象来获取。-->
    ```

  - 获取应用的根路径（非常重要），因为在java源代码当中有一些地方可能会需要应用的根路径，这个方法可以动态获取应用的根路径
  - 在java源码当中，不要将应用的根路径写死，因为你永远都不知道这个应用在最终部署的时候，起一个什么名字。
  - `public String getContextPath();`

  - 获取文件的绝对路径（真实路径）
  - `public String getRealPath(String path);`

  - ```java
    // 通过ServletContext对象也是可以记录日志的
    public void log(String message);
    public void log(String message, Throwable t);
    // 这些日志信息记录到哪里了？
    // localhost.2021-11-05.log
    
    // Tomcat服务器的logs目录下都有哪些日志文件？
    // catalina.2021-11-05.log 服务器端的java程序运行的控制台信息。
    // localhost.2021-11-05.log ServletContext对象的log方法记录的日志信息存储到这个文件中。
    // localhost_access_log.2021-11-05.txt 访问日志
    ```

  ServletContext对象还有另一个名字：应用域（后面还有其他域，例如：请求域、会话域）
  如果所有的用户共享一份数据，并且这个数据很少的被修改，并且这个数据量很少，可以将这些数据放到ServletContext这个应用域中

  - 为什么是所有用户共享的数据？ 
    - 不是共享的没有意义。因为ServletContext这个对象只有一个。只有共享的数据放进去才有意义。
  - 为什么数据量要小？ 
    - 因为数据量比较大的话，太占用堆内存，并且这个对象的生命周期比较长，服务器关闭的时候，这个对象才会被销毁。大数据量会影响服务器的性能。占用内存较小的数据量可以考虑放进去。
  - 为什么这些共享数据很少的修改，或者说几乎不修改？ 
    - 所有用户共享的数据，如果涉及到修改操作，必然会存在线程并发所带来的安全问题。所以放在ServletContext对象中的数据一般都是只读的。
  - 数据量小、所有用户共享、又不修改，这样的数据放到ServletContext这个应用域当中，会大大提升效率。因为应用域相当于一个缓存，放到缓存中的数据，下次在用的时候，不需要从数据库中再次获取，大大提升执行效率。

  - ```java
    // 存（怎么向ServletContext应用域中存数据）
    public void setAttribute(String name, Object value); // map.put(k, v)
    // 取（怎么从ServletContext应用域中取数据）
    public Object getAttribute(String name); // Object v = map.get(k)
    // 删（怎么删除ServletContext应用域中的数据）
    public void removeAttribute(String name); // map.remove(k)
    ```

- 注意：以后我们编写Servlet类的时候，实际上是不会去直接继承GenericServlet类的，因为我们是B/S结构的系统，这种系统是基于HTTP超文本传输协议的，在Servlet规范当中，提供了一个类叫做HttpServlet，它是专门为HTTP协议准备的一个Servlet类。我们编写的Servlet类要继承HttpServlet。（HttpServlet是HTTP协议专用的。）使用HttpServlet处理HTTP协议更便捷。但是你需要直到它的继承结构：

  - ```
    jakarta.servlet.Servlet（接口）
    jakarta.servlet.GenericServlet implements Servlet（抽象类）
    jakarta.servlet.http.HttpServlet extends GenericServlet（抽象类）
    
    我们以后编写的Servlet要继承HttpServlet类。
    ```

- 大家到目前为止都接触过哪些缓存机制了？

  - 堆内存当中的字符串常量池。
    - "abc" 先在字符串常量池中查找，如果有，直接拿来用。如果没有则新建，然后再放入字符串常量池。
  - 堆内存当中的整数型常量池。
    - [-128 ~ 127] 一共256个Integer类型的引用，放在整数型常量池中。没有超出这个范围的话，直接从常量池中取。
  - 连接池(Connection Cache)
    - 这里所说的连接池中的连接是java语言连接数据库的连接对象：java.sql.Connection对象。
    - JVM是一个进程。MySQL数据库是一个进程。进程和进程之间建立连接，打开通道是很费劲的。是很耗费资源的。怎么办？可以提前先创建好N个Connection连接对象，将连接对象放到一个集合当中，我们把这个放有Connection对象的集合称为连接池。每一次用户连接的时候不需要再新建连接对象，省去了新建的环节，直接从连接池中获取连接对象，大大提升访问效率。
    - 连接池
      - 最小连接数
      - 最大连接数
      - 连接池可以提高用户的访问效率。当然也可以保证数据库的安全性。
  - 线程池
    - Tomcat服务器本身就是支持多线程的。
    - Tomcat服务器是在用户发送一次请求，就新建一个Thread线程对象吗？
      - 当然不是，实际上是在Tomcat服务器启动的时候，会先创建好N多个线程Thread对象，然后将线程对象放到集合当中，称为线程池。用户发送请求过来之后，需要有一个对应的线程来处理这个请求，这个时候线程对象就会直接从线程池中拿，效率比较高。
      - 所有的WEB服务器，或者应用服务器，都是支持多线程的，都有线程池机制。
  - redis
    - NoSQL数据库。非关系型数据库。缓存数据库。
  - 向ServletContext应用域中存储数据，也等于是将数据存放到缓存cache当中了。

