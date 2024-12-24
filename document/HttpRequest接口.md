## HttpServletRequest接口详解

- HttpServletRequest是一个接口，全限定名称：jakarta.servlet.http.HttpServletRequest
- HttpServletRequest接口是Servlet规范中的一员。
- HttpServletRequest接口的父接口：ServletRequest 
  + `public interface HttpServletRequest extends ServletRequest {}`

- HttpServletRequest接口的实现类谁写的? HttpServletRequest对象是谁给创建的？
    - 通过测试：org.apache.catalina.connector.RequestFacade 实现了 HttpServletRequest接口
    + `public class RequestFacade implements HttpServletRequest {}`

    - 测试结果说明：Tomcat服务器（WEB服务器、WEB容器）实现了HttpServletRequest接口，还是说明了Tomcat服务器实现了Servlet规范。而对于我们javaweb程序员来说，实际上不需要关心这个，我们只需要面向接口编程即可。我们关心的是HttpServletRequest接口中有哪些方法，这些方法可以完成什么功能

- HttpServletRequest对象中都有什么信息？都包装了什么信息？

    - HttpServletRequest对象是Tomcat服务器负责创建的。这个对象中封装了什么信息？封装了HTTP的请求协议。
    - 实际上是用户发送请求的时候，遵循了HTTP协议，发送的是HTTP的请求协议，Tomcat服务器将HTTP协议中的信息以及数据全部解析出来，然后Tomcat服务器把这些信息封装到HttpServletRequest对象当中，传给了我们javaweb程序员。
    - javaweb程序员面向HttpServletRequest接口编程，调用方法就可以获取到请求的信息了。

- request和response对象的生命周期？

    - request对象和response对象，一个是请求对象，一个是响应对象。这两个对象只在当前请求中有效。
    - 一次请求对应一个request。
    - 两次请求则对应两个request。
    - .....

- HttpServletRequest接口中有哪些常用的方法？

    - 怎么获取前端浏览器用户提交的数据？
        - ```java
            Map<String,String[]> getParameterMap() 这个是获取Map
            Enumeration<String> getParameterNames() 这个是获取Map集合中所有的key
            String[] getParameterValues(String name) 根据key获取Map集合的value
            String getParameter(String name)  获取value这个一维数组当中的第一个元素。这个方法最常用。
            // 以上的4个方法，和获取用户提交的数据有关系。
          ```

        - 思考：如果是你，前端的form表单提交了数据之后，你准备怎么存储这些数据，你准备采用什么样的数据结构去存储这些数据呢？

            - 前端提交的数据格式：username=abc&userpwd=111&aihao=s&aihao=d&aihao=tt
            - 我会采用Map集合来存储：
            - ```text
              Map<String,String>
              key存储String
              value存储String
              这种想法对吗？不对。
              如果采用以上的数据结构存储会发现key重复的时候value覆盖。
              key         value
              ---------------------
              username    abc
              userpwd     111
              aihao       s
              aihao       d
              aihao       tt
              这样是不行的，因为map的key不能重复。
              Map<String, String[]>
              key存储String
              value存储String[]
              key				value
              -------------------------------
              username		{"abc"}
              userpwd		{"111"}
              aihao			{"s","d","tt"}
              ```
            - 注意：前端表单提交数据的时候，假设提交了120这样的“数字”，其实是以字符串"120"的方式提交的，所以服务器端获取到的一定是一个字符串的"120"，而不是一个数字。（前端永远提交的是字符串，后端获取的也永远是字符串。）

    - 手工开发一个webapp。测试HttpServletRequest接口中的相关方法。

        - 先测试了4个常用的方法，获取请求参数的四个方法。

            - ```java
        	Map<String,String[]> parameterMap = request.getParameterMap();
        	Enumeration<String> names = request.getParameterNames();
        	String[] values = request.getParameterValues("name");
        	String value = request.getParameter("name");
        ```



    - request对象实际上又称为“请求域”对象。
      - 应用域对象是什么？

        - ServletContext （Servlet上下文对象。）

        - 什么情况下会考虑向ServletContext这个应用域当中绑定数据呢？

          - 第一：所有用户共享的数据。
          - 第二：这个共享的数据量很小。
          - 第三：这个共享的数据很少的修改操作。
          - 在以上三个条件都满足的情况下，使用这个应用域对象，可以大大提高我们程序执行效率。
          - 实际上向应用域当中绑定数据，就相当于把数据放到了缓存（Cache）当中，然后用户访问的时候直接从缓存中取，减少IO的操作，大大提升系统的性能，所以缓存技术是提高系统性能的重要手段。

        - 你见过哪些缓存技术呢？

          - 字符串常量池
          - 整数型常量池 [-128~127]，但凡是在这个范围当中的Integer对象不再创建新对象，直接从这个整数型常量池中获取。大大提升系统性能。
          - 数据库连接池（提前创建好N个连接对象，将连接对象放到集合当中，使用连接对象的时候，直接从缓存中拿。省去了连接对象的创建过程。效率提升。）
          - 线程池（Tomcat服务器就是支持多线程的。所谓的线程池就是提前先创建好N个线程对象，将线程对象存储到集合中，然后用户请求过来之后，直接从线程池中获取线程对象，直接拿来用。提升系统性能）
          - 后期你还会学习更多的缓存技术，例如：redis、mongoDB.....

        - ServletContext当中有三个操作域的方法：

          - ```java
            void setAttribute(String name, Object obj); // 向域当中绑定数据。
            Object getAttribute(String name); // 从域当中根据name获取数据。
            void removeAttribute(String name); // 将域当中绑定的数据移除
            
            // 以上的操作类似于Map集合的操作。
            Map<String, Object> map;
            map.put("name", obj); // 向map集合中放key和value
            Object obj = map.get("name"); // 通过map集合的key获取value
            map.remove("name"); // 通过Map集合的key删除key和value这个键值对。
            ```

      - “请求域”对象

        - “请求域”对象要比“应用域”对象范围小很多。生命周期短很多。请求域只在一次请求内有效。

        - 一个请求对象request对应一个请求域对象。一次请求结束之后，这个请求域就销毁了。

        - 请求域对象也有这三个方法：

          - ```java
            void setAttribute(String name, Object obj); // 向域当中绑定数据。
            Object getAttribute(String name); // 从域当中根据name获取数据。
            void removeAttribute(String name); // 将域当中绑定的数据移除
            ```

        - 请求域和应用域的选用原则？

          - 尽量使用小的域对象，因为小的域对象占用的资源较少。
        
      - 跳转
      
        - 转发（一次请求）
      
          - ```java
            // 第一步：获取请求转发器对象
            RequestDispatcher dispatcher = request.getRequestDispatcher("/b");
            // 第二步：调用转发器的forward方法完成跳转/转发
            dispatcher.forward(request,response);
            
            // 第一步和第二步代码可以联合在一起。
            request.getRequestDispatcher("/b").forward(request,response);
            
            ```
      
      - 两个Servlet怎么共享数据？
      
        - 将数据放到ServletContext应用域当中，当然是可以的，但是应用域范围太大，占用资源太多。不建议使用。
        - 可以将数据放到request域当中，然后AServlet转发到BServlet，保证AServlet和BServlet在同一次请求当中，这样就可以做到两个Servlet，或者多个Servlet共享同一份数据。
      
      - 转发的下一个资源必须是一个Servlet吗？
      
        - 不一定，只要是Tomcat服务器当中的合法资源，都是可以转发的。例如：html....
        - 注意：转发的时候，路径的写法要注意，转发的路径以“/”开始，不加项目名。
      
      - 关于request对象中两个非常容易混淆的方法：
      
        - ```java
          
          // uri?username=zhangsan&userpwd=123&sex=1
          String username = request.getParameter("username");
          
          // 之前一定是执行过：request.setAttribute("name", new Object())
          Object obj = request.getAttribute("name");
          
          // 以上两个方法的区别是什么？
          // 第一个方法：获取的是用户在浏览器上提交的数据。
          // 第二个方法：获取的是请求域当中绑定的数据。
          ```
      
      - HttpServletRequest接口的其他常用方法：
      
        - ```java
          // 获取客户端的IP地址
          String remoteAddr = request.getRemoteAddr();
          
          // get请求在请求行上提交数据。
          // post请求在请求体中提交数据。
          // 设置请求体的字符集。（显然这个方法是处理POST请求的乱码问题。这种方式并不能解决get请求的乱码问题。）
          // Tomcat10之后，request请求体当中的字符集默认就是UTF-8，不需要设置字符集，不会出现乱码问题。
          // Tomcat9前（包括9在内），如果前端请求体提交的是中文，后端获取之后出现乱码，怎么解决这个乱码？执行以下代码。
          request.setCharacterEncoding("UTF-8");
          
          // 在Tomcat9之前（包括9），响应中文也是有乱码的，怎么解决这个响应的乱码？
          response.setContentType("text/html;charset=UTF-8");
          // 在Tomcat10之后，包括10在内，响应中文的时候就不在出现乱码问题了。以上代码就不需要设置UTF-8了。
          
          // 注意一个细节
          // 在Tomcat10包括10在内之后的版本，中文将不再出现乱码。（这也体现了中文地位的提升。）
          
          // get请求乱码问题怎么解决？
          // get请求发送的时候，数据是在请求行上提交的，不是在请求体当中提交的。
          // get请求乱码怎么解决
          // 方案：修改CATALINA_HOME/conf/server.xml配置文件
          <Connector URIEncoding="UTF-8" />
          // 注意：从Tomcat8之后，URIEncoding的默认值就是UTF-8，所以GET请求也没有乱码问题了。
              
          // 获取应用的根路径
          String contextPath = request.getContextPath();
          
          // 获取请求方式
          String method = request.getMethod();
          
          // 获取请求的URI
          String uri = request.getRequestURI();  // /aaa/testRequest
          
          // 获取servlet path
          String servletPath = request.getServletPath(); //   /testRequest
          
          ```