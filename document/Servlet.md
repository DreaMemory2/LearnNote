# Servlet

## 关于系统架构

1. 系统架构包括：
    - C/S架构
    - B/S架构
2. C/S架构
    - Client / Server（客户端 / 服务器）
    - C/S架构的软件或者系统
        - QQ软件
    - C/S架构的特点：需要安装特定的客户端软件
    - C/S架构的系统优点和缺点
        - 优点：
            - 速度快
            - 体验好
            - 界面酷炫
            - 服务器压力小
            - 更安全
        - 缺点：
            - 升级维护比较差劲
3. B/S架构
    - Browser / Server （浏览器 / 服务器）
    - http://www.baidu.com
    - http://www.jd.com
    - http://www.126.com
    - B/S结构的系统是一个特殊的C/S系统
        - 实际上B/S结构的系统还是一个C/S，只不过这个C比较特殊，这个Client是一个固定不变浏览器软件
    - B/S结构的系统优点和缺点是：
        - 优点：
            - 升级维护方便，成本比较低
            - 不需要安装特定的客户端软件，用户操作极其方便。只需要打开浏览器，输入网址即可
        - 缺点：
            - 速度慢
            - 体验差
            - 不安全
4. C/S和B/S结构的系统的对比
    - 公司内部使用的一些业务软件建议使用
        - 公司内部使用的系统，需要维护成本低
        - 公司内部使用的系统，不需要很酷炫
        - 公司内部使用的企业级系统主要是能够进行数据的维护即可
        - B/S 结构
5. 开发B/S结构的系统，开发一个WEB系统
    - 开发一个WEB系统的技术
        - WEB前端（运行在浏览器上的程序）
            - HTML
            - CSS
            - JavaScript
        - WEB后端（WEB服务器端的程序）
            - Java（Java做WEB开发我们称为JavaWEB开发。JavaWEB开发最核心的规范：Servlet【Server Applet服务器端的Java小程序】）
            - C语言
            - C++
            - Python
            - PHP
6. JavaEE
    - Java包括三大块：
        - JavaSE
        - JavaEE（WEB方向，WEB系统）
            - Java企业版（也是一套类库：也是别人写好的一套类库，只不过这套类库可以帮助我们完成企业级项目的开发，专门为企业内部提供解决方案的一套（多套）类库。）
            - 可以开发web系统
        - JavaME
            - Java微型版（还是一套类库，只不过这套类库帮助我们进行电子微型设备内核程序的开发）
            - 机顶盒内核程序，吸尘器内核程序，电冰箱内核程序，电饭煲内核程序。。。。。
    - JavaEE实际上包括很多种规范，13种规范，其中Servlet就是JavaEE规范之一

## B/S结构的系统通信原理

- WEB系统的访问过程
    - 第一步：打开浏览器
    - 第二步：找到地址栏
    - 第三步：输入一个合法的网址
    - 第四步：回车
    - 第五步：在浏览器上会展示响应的结果
- 关于域名：
    - https://www.baidu.com/ （网址）
    - www.baidu.com 是一个域名
    - 在浏览器地址栏上输入域名，回车之后，域名解析器会将域名解析出来一个具体的IP地址和端口号
    - 解析结果也许是：http://110.242.68.3:80/index.html
- IP地址
    - 计算机在网络当中的一个身份证号。在同一个网络当中，IP地址是唯一的
    - A计算机要想和B计算机通信，首先你需要知道B计算机的IP地址，有了IP地址才能建立连接
- 端口号
    - 一个端口代表一个软件（一个端口代表一个应用，一个端口仅代表一个服务）
    - 一个计算机当中有很多软件，每一个软件启动之后都有一个端口号
    - 在同一个计算机上，端口号具有唯一性
- WEB系统的通信原理
    - 第一步：用户输入网址（URL）
    - 第二步：域名解析器进行域名解析：http://110.242.68.3:80/index.html
    - 第三步：浏览器软件在网络中搜索110.242.68.3这一台主机，直到找到这台主机
    - 第四步：定位110.242.68.3这台主机上的服务器软件，因为是80端口，可以很轻松的定位到80端口对应的服务器软件
    - 第五步：80端口对应的服务器软件得知浏览器想要的资源名是：index.html
    - 第六步：服务器软件找到index.html文件，并且将index.html文件中的内容直接输出响应到浏览器上
    - 第七步：浏览器接收到来自服务器的代码（HTML CSS JS）
    - 第八步：浏览器渲染，执行HTML CSS JS代码，展示效果
- URL
    - 统一资源定位符（http://www.baidu.com）
- 请求和响应
    - 请求和响应实际上说的是数据的流向不同
    - 从Browser端发送数据到Server端，我们称为请求。英语单词：request
    - 从Server端向浏览器Browser端发送数据，我们称为响应。英语单词：response
    - B --> S （请求request）
    - S --> B （响应response）

## 关于WEB服务器软件

- WEB服务器软件
    - Tomcat（WEB服务器）
    - jetty（WEB服务器）
    - JBOSS（应用服务器）
    - WebLogic（应用服务器）
    - WebSphere（应用服务器）
    - 
- 应用服务器和WEB服务器的关系
    - 应用服务器实现了JavaEE的所有规范
    - WEB服务器只实现了JavaEE中的Servlet + JSP两个核心的规范
    - 通过这个讲解说明了：应用服务器是包含WEB服务器的
    - 用过JBOSS服务器的同学应该很清楚，JBOSS中内嵌了一个Tomcat服务器
- Tomcat下载
    - apache官网地址：https://www.apache.org/
    - tomcat官网地址：https://tomcat.apache.org
    - tomcat开源免费的轻量级WEB服务器。
    - catalina（catalina是美国的一个岛屿，风景秀丽，据说作者是在这个风景秀丽的小岛上开发了一个轻量级的WEB服务器，体积小，运行速度快，因此tomcat又被称为catalina）
    - tomcat的logo是一只公猫（寓意表示Tomcat服务器是轻巧的，小巧的，果然，体积小，运行速度快，只实现了Servlet+JSP规范）
    - tomcat是java语言写的
    - tomcat服务器要想运行，必须先又jre（Java的运行时环境）
- Tomcat服务器要想运行，需要先有JRE，所以要先安装JDK，配置java运行环境
- Tomcat服务器的安装：
    - 绿色版本的安装很简单，直接zip包解压即可。解压就是安装。
    - 启动Tomcat
        - bin目录下有一个文件：startup.bat, 通过它可以启动Tomcat服务器
            - bat文件是windows操作系统专用的，bat文件是批处理文件，这种文件中可以编写大量的windows的dos命令，然后执行bat文件就相当于批量的执行dos命令
            - startup.sh，在Linux环境当中可以使用。在Linux环境下能够执行的是shell命令，大量的shell命令编写在shell文件当中，然后执行这个shell文件可以批量的执行shell命令
            - tomcat服务器提供了bat和sh文件，说明了这个tomcat服务器的通用性
            - 分析startup.bat文件得出，执行这个命令，实际上最后是执行：catalina.bat文件
            - catalina.bat文件中有这样一行配置：MAINCLASS=org.apache.catalina.startup.Bootstrap （这个类就是main方法所在的类。）
            - tomcat服务器就是Java语言写的，既然是java语言写的，那么启动Tomcat服务器就是执行main方法
        - 我们尝试打开dos命令窗口，在dos命令窗口中输入startup.bat来启动tomcat服务器
        - 启动Tomcat服务器只配置path对应的bin目录是不行的。有两个环境变量需要配置：
            - JAVA_HOME=JDK的根
            - CATALINA_HOME=Tomcat服务器的根
- 关于Tomcat服务器的目录
    - bin ： 这个目录是Tomcat服务器的命令文件存放的目录，比如：启动Tomcat，关闭Tomcat等。
    - conf： 这个目录是Tomcat服务器的配置文件存放目录。（server.xml文件中可以配置端口号，默认Tomcat端口是8080）
    - lib ：这个目录是Tomcat服务器的核心程序目录，因为Tomcat服务器是Java语言编写的，这里的jar包里面都是class文件
    - logs: Tomcat服务器的日志目录，Tomcat服务器启动等信息都会在这个目录下生成日志文件
    - temp：Tomcat服务器的临时目录。存储临时文件
    - webapps：这个目录当中就是用来存放大量的webapp（web application：web应用）
    - work：这个目录是用来存放JSP文件翻译之后的java文件以及编译之后的class文件

- 配置Tomcat服务器需要哪些环境变量？
    - JAVA_HOME=JDK的根
    - CATALINA_HOME=Tomcat服务器的根
    - PATH=%JAVA_HOME%\bin;%CATALINA_HOME%\bin
- 启动Tomcat：startup
- 关闭Tomcat：stop （shutdown.bat文件重命名为stop.bat，原因是shutdown命令和windows中的关机命令冲突）

- 测试Tomcat服务器有没有启动成功
    - 打开浏览器，在浏览器的地址栏上输入URL: https://localhost:8080/
    - 
## 实现一个最基本的web应用

- 第一步：找到CATALINA_HOME\webapps目录
    - 因为所有的webapp要放到webapps目录下

- 第二步：在CATALINA_HOME\webapps目录下新建一个子目录
    - 起名oa，这个目录名oa就是你这个webapp的名字
  
- 第三步：在oa目录下新建资源文件，例如：index.html
    - 编写index.html文件的内容。
 
- 第四步：启动Tomcat服务器
- 第五步：打开浏览器，在浏览器地址栏上输入这样的URL：

- http://localhost:8080/oa/index.html

- 我们在浏览器上直接输入一个URL，然后回车。这个动作和超链接一样吗？既然是一样的，我们完全可以使用超链接。

```html
<!--注意以下的路径，以/开始，带项目名，是一个绝对路径。不需要添加：http://127.0.0.1:8080-->
<a href="/oa/login.html">User Login</a>
```

- http://localhost:8080/oa/userList.html
    - 访问这个地址，可以展示一个用户列表页面。这种资源我们称为静态资源
    - 变成动态资源。需要连接数据库，连接数据库需要JDBC程序，也需要编写Java程序连接数据库
    - 数据库中有多少条记录，页面上就显示多少条记录，这种技术被称为动态网页技术

## 对于一个动态的web应用来说，一个请求和响应的过程有多少个角色参与，角色和角色之间有多少个协议

![BS结构系统的通信原理2](D:\course\01-Servlet\文档\BS结构系统的通信原理2.png)

- 有哪些角色（在整个BS结构的系统当中，有哪些人参与进去了）
    - 浏览器软件的开发团队（谷歌浏览器、火狐浏览器、Edge浏览器）
    - WEB Server的开发团队（Tomcat、Jetty、WebLogic、JBOSS、WebSphere）
    - DB Server的开发团队（Oracle、MySQL）
    - webapp的开发团队（WEB应用是我们做为JavaWEB程序员开发的）
- 角色和角色之间需要遵守的规范和协议
    - webapp的开发团队和WEB Server的开发团队之间有一套规范: JavaEE规范之一Servlet规范
        - Servlet规范的作用
            - WEB Server和webapp解耦合
    - Browser和WebServer之间有一套传输协议：HTTP协议（超文本传输协议）
    - webapp开发团队和DB Server的开发团队之间有一套规范：JDBC规范

![BS结构系统的角色和协议](D:\course\01-Servlet\文档\BS结构系统的角色和协议.png)

- Servlet规范
    - 遵循Servlet规范的webapp，这个webapp就可以放在不同的WEB服务器中运行
    - Servlet规范包括
        - 规范了哪些接口
        - 规范了哪些类
        - 规范了一个web应用中应该有哪些配置文件
        - 规范了一个web应用中配置文件的名字
        - 规范了一个web应用中配置文件存放的路径
        - 规范了一个web应用中配置文件的内容
        - 规范了一个合法有效的web应用它的目录结构应该是怎样的。


## 开发一个带有Servlet的webapp

- 开发步骤
    - 第一步：在webapps目录下新建一个目录，起名crm（这个crm就是webapp的名字）。当然，也可以是其它项目，比如银行项目，可以创建一个目录bank，办公系统可以创建一个oa
        - 注意：crm就是这个webapp的根
    - 第二步：在webapp的根下新建一个目录：WEB-INF
        - 注意：这个目录的名字是Servlet规范中规定的
    - 第三步：在WEB-INF目录下新建一个目录：classes
        - 注意：这个目录的名字必须是全部小写的classes。这也是Servlet规范中规定的。这个目录下一定存放的是Java程序编译之后的class文件
    - 第四步：在WEB-INF目录下新建一个目录：lib
        - 注意：这个目录不是必须的。但如果一个webapp需要第三方的jar包的话，这个jar包要放到这个lib目录下
        - 这个目录的名字也不能随意编写，必须是全部小写的lib。这Servlet规范中规定的
    - 第五步：在WEB-INF目录下新建一个文件：web.xml
        - 注意：这个文件是必须的，这个文件名必须叫做web.xml，它是一个配置文件，在这个配置文件中描述了请求路径和Servlet类之间的对照关系
        - ```xml
          <?xml version="1.0" encoding="UTF-8"?>
          <web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
                   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
                                https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
                   version="5.0"
                   metadata-complete="true">

          </web-app>
          ```
    - 第六步：编写一个Java程序，必须实现Servlet接口
        - 这个Servlet接口不在JDK当中（因为Servlet不是JavaSE，Servlet属于JavaEE是另外的一套类库）
        - Servlet接口（Servlet.class文件）是Oracle提供的（最原始的是sun公司提供的）
        - Servlet接口是JavaEE的规范中的一员
        - Tomcat服务器实现了Servlet规范，所以Tomcat服务器也需要使用Servlet接口。Tomcat服务器中应该有这个接口，Tomcat服务器的CATALINA_HOME\lib目录下有一个servlet-api.jar，解压这个servlet-api.jar之后，你会看到里面有一个Servlet.class文件
        - 重点：从JakartaEE9开始，Servlet接口的全名变了：jakarta.servlet.Servlet
        - 注意：编写这个Java小程序的时候，java源代码的位置无所谓，只需要将java源代码编译之后的class文件放到classes目录下
    - 第七步：编译我们编写的HelloServlet
        - 重点：HelloServlet编译通过，通过配置环境变量CLASSPATH
          CLASSPATH=.;C:\dev\apache-tomcat-10.0.12\lib\servlet-api.jar
        - 和运行没有任何关系，只是正常编译通过就行
    - 第八步：将以上编译之后的HelloServlet.class文件拷贝到WEB-INF\classes目录下
    - 第九步：在web.xml文件中编写配置信息，让“请求路径”和“Servlet类名”关联在一起。
        - 这一步用专业术语描述：在web.xml文件中注册Servlet类。
        - ```xml
          <!-- Servlet描述信息 -->
          <!-- 任何一个Servlet对应一个servlet-mapping -->
          <servlet>
      	       <servlet-name>HelloWorldServlet</servlet-name>
      	       <!-- 这个位置必须是带有包名的全限定类名 -->
      	       <servlet-class>com.bjpowernode.servlet.HelloWorldServlet</servlet-class>
          </servlet>
          
          <!-- Servlet映射信息 -->
          <servlet-mapping>
              <!-- 必须保持域上面的名称保持一致性 -->
      	     <servlet-name>HelloWorldServlet</servlet-name>
      	     <!-- 这里需要路径，并且必须以"/"开始 -->
      	     <url-partern>/helloworld</url-partern>
          </servlet-mapping>
          ```
- 第十步：启动Tomcat服务器
- 第十一步：打开浏览器，在浏览器地址栏上输入一个url，这个URL必须是：
    - http://localhost:8080/tutorial/helloworld
    - 非常重要的一件事：浏览器上的请求路径不能随便写，这个请求路径必须和web.xml文件中的url-pattern一致。
    - 注意：浏览器上的请求路径和web.xml文件中的url-pattern的唯一区别就是：浏览器上的请求路径带项目名：/crm
- 浏览器上编写的路径太复杂，可以使用超链接。（**非常重要：html页面只能放到WEB-INF目录外面。**）
- 以后不需要我们编写main方法了。tomcat服务器负责调用main方法，Tomcat服务器启动的时候执行的就是main方法。我们Javaweb程序员只需要编写Servlet接口的实现类，然后将其注册到web.xml文件中，即可

- 总结一下：一个合法的webapp目录结构

  ```
  webapproot
       |------WEB-INF
                 |------classes(存放字节码)
                 |------lib(第三方jar包)
                 |------web.xml(注册Servlet)
       |------html
       |------css
       |------javascript
       |------image
       ....
  ```

- 浏览器发送请求，到最终服务器调用Servlet中的方法
    - 用户输入URL，或者直接点击超链接：http://127.0.0.1:8080/crm/fdsa/fd/saf/d/sa/fd/sa/fd
    - 然后Tomcat服务器接收到请求
    - Tomcat服务器找到crm项目
    - Tomcat服务器在web.xml文件中查找对应的Servlet：com.bjpowernode.servlet.HelloServlet
    - Tomcat服务器通过反射机制，创建com.bjpowernode.servlet.HelloServlet的对象
    - Tomcat服务器调用com.bjpowernode.servlet.HelloServlet对象的service方法

## 关于JavaEE的版本

- JavaEE目前最高版本是 JavaEE8
- JavaEE被Oracle捐献了，Oracle将JavaEE规范捐献给Apache了。
- Apache把JavaEE换名了，以后不叫JavaEE了，以后叫做 jakarta EE。
- 以后没有JavaEE了。以后都叫做Jakarta EE。
- JavaEE8版本升级之后的"JavaEE 9"，不再是"JavaEE9"这个名字了，叫做JakartaEE9
- JavaEE8的时候对应的Servlet类名是：javax.servlet.Servlet
- JakartaEE9的时候对应的Servlet类名是：jakarta.servlet.Servlet （包名都换了）
- 如果你之前的项目还是在使用javax.servlet.Servlet，那么你的项目无法直接部署到Tomcat10+版本上。你只能部署到Tomcat9-版本上。在Tomcat9以及Tomcat9之前的版本中还是能够识别javax.servlet这个包。

## 解决Tomcat服务器在DOS命令窗口中的乱码问题（控制台乱码）
将CATALINA_HOME/conf/logging.properties文件中的内容修改如下：
java.util.logging.ConsoleHandler.encoding = GBK

## 向浏览器响应一段HTML代码

```java
public void service(ServletRequest request, ServletResponse response){
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.print("<h1>hello servlet!</h1>");
}
```

## 在Servlet中连接数据库，怎么做？

- Servlet是Java程序，所以在Servlet中完全可以编写JDBC代码连接数据库
- 在一个webapp中去连接数据库，需要将驱动jar包放到WEB-INF/lib目录下（com.mysql.cj.jdbc.Driver 这个类就在驱动jar包当中）