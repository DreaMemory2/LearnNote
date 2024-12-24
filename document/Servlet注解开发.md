## Servlet注解，简化配置

- 分析oa项目中的web.xml文件
    - 现在只是一个单标的CRUD，没有复杂的业务逻辑，很简单的一丢丢功能。web.xml文件中就有如此多的配置信息。如果采用这种方式，对于一个大的项目来说，这样的话web.xml文件会非常庞大，有可能最终会达到几十兆。
    - 在web.xml文件中进行servlet信息的配置，显然开发效率比较低，每一个都需要配置一下。
    - 而且在web.xml文件中的配置是很少被修改的，所以这种配置信息能不能直接写到java类当中呢？可以的。

- Servlet3.0版本之后，推出了各种Servlet基于注解式开发。优点是什么？
    - 开发效率高，不需要编写大量的配置信息。直接在java类上使用注解进行标注。
    - web.xml文件体积变小了。

- 并不是说注解有了之后，web.xml文件就不需要了：
    - 有一些需要变化的信息，还是要配置到web.xml文件中。一般都是 注解+配置文件 的开发模式。
    - 一些不会经常变化修改的配置建议使用注解。一些可能会被修改的建议写到配置文件中。

- 我们的第一个注解：

    - `jakarta.servlet.annotation.WebServlet`
    - 在Servlet类上使用：@WebServlet，WebServlet注解中有哪些属性呢？
        - name属性：用来指定Servlet的名字。等同于：<servlet-name>
        - urlPatterns属性：用来指定Servlet的映射路径。可以指定多个字符串。<url-pattern>
        - loadOnStartUp属性：用来指定在服务器启动阶段是否加载该Servlet。等同于：<load-on-startup>
        - value属性：当注解的属性名是value的时候，使用注解的时候，value属性名是可以省略的。
        - 注意：不是必须将所有属性都写上，只需要提供需要的。（需要什么用什么。）
        - 注意：属性是一个数组，如果数组中只有一个元素，使用该注解的时候，属性值的大括号可以省略。

- 注解对象的使用格式：
    - @注解名称(属性名=属性值, 属性名=属性值, 属性名=属性值....)



## 关于B/S结构系统的会话机制（session机制）

- 什么是会话？
    - 会话对应的英语单词：session
    - 用户打开浏览器，进行一系列操作，然后最终将浏览器关闭，这个整个过程叫做：一次会话。会话在服务器端也有一个对应的java对象，这个java对象叫做：session。
    - 什么是一次请求：用户在浏览器上点击了一下，然后到页面停下来，可以粗略认为是一次请求。请求对应的服务器端的java对象是：request。
    - 一个会话当中包含多次请求。（一次会话对应N次请求。）

- 在java的servlet规范当中，session对应的类名：HttpSession（jarkata.servlet.http.HttpSession）

- session机制属于B/S结构的一部分。如果使用php语言开发WEB项目，同样也是有session这种机制的。session机制实际上是一个规范。然后不同的语言对这种会话机制都有实现。

- session对象最主要的作用是：保存会话状态。（用户登录成功了，这是一种登录成功的状态，你怎么把登录成功的状态一直保存下来呢？使用session对象可以保留会话状态。）

- 为什么需要session对象来保存会话状态呢？
    - 因为HTTP协议是一种无状态协议。
    - 什么是无状态：请求的时候，B和S是连接的，但是请求结束之后，连接就断了。为什么要这么做？HTTP协议为什么要设计成这样？因为这样的无状态协议，可以降低服务器的压力。请求的瞬间是连接的，请求结束之后，连接断开，这样服务器压力小。
    - 只要B和S断开了，那么关闭浏览器这个动作，服务器知道吗？
        - 不知道。服务器是不知道浏览器关闭的。

- 张三打开一个浏览器A，李四打开一个浏览器B，访问服务器之后，在服务器端会生成：
    - 张三专属的session对象
    - 李四专属的session对象

- 为什么不使用request对象保存会话状态？为什么不使用ServletContext对象保存会话状态？
    - request.setAttribute()存，request.getAttribute()取，ServletContext也有这个方法。request是请求域。ServletContext是应用域。
    - request是一次请求一个对象。
    - ServletContext对象是服务器启动的时候创建，服务器关闭的时候销毁，这个ServletContext对象只有一个。
    - ServletContext对象的域太大。
    - request请求域（HttpServletRequest）、session会话域（HttpSession）、application域（ServletContext）
    - request < session < application

- 思考一下：session对象的实现原理。
    - HttpSession session = request.getSession();
    - 这行代码很神奇。张三访问的时候获取的session对象就是张三的。李四访问的时候获取的session对象就是李四的。

- session的实现原理：

    - JSESSIONID=xxxxxx  这个是以Cookie的形式保存在浏览器的内存中的。浏览器只要关闭。这个cookie就没有了。
    - session列表是一个Map，map的key是sessionid，map的value是session对象。
    - 用户第一次请求，服务器生成session对象，同时生成id，将id发送给浏览器。
    - 用户第二次请求，自动将浏览器内存中的id发送给服务器，服务器根据id查找session对象。
    - 关闭浏览器，内存消失，cookie消失，sessionid消失，会话等同于结束。