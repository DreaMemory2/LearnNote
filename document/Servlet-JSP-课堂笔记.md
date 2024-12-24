# 关于直播

1. 什么时间直播？
   - 晚上8:00到10:00
2. 每周直播几天？
   - 3天（周一、周三、周五）
   - 本周比较特殊：周四周五周六三天直播，从下周开始就是一三五直播。
3. 直播什么内容？
   - 从JavaWEB开始。（Servlet为核心，从Servlet开始学习。）
   - JSP（JSP使用较少了，但是还有用，所以时间上少一些。快速地学习一下JSP。）
   - AJAX（异步通信技术。）
   - jQuery（JavaScript库。）
   - MyBatis
   - Spring
   - SpringMVC
   - SpringBoot
   - SpringCloud
   - ....

# 需要提前准备了哪些技术，接下来的课才能听懂？

- JavaSE（Java语言的标准版，Java提供的最基本的类库）
  - Java的开发环境搭建
  - Java的基础语法
  - Java的面向对象
  - 数组
  - 常用类
  - 异常
  - 集合
  - 多线程
  - IO流
  - 反射机制
  - 注解Annotation
  - .....
- MySQL（数据库）
  - 最基本的要求是：能够编写增删改查等简单的SQL语句即可。
- JDBC（Java语言链接数据库）
  - 这是一套Java语言链接数据库的接口。
- WEB前端（会一些）
  - HTML（网页）
  - CSS（层叠样式表语言，修饰HTML）
  - JavaScript（一种脚本语言，运行在浏览器当中，让浏览器中的元素可以增删改。让网页产生更强的交互效果）
- WEB后端
  - Servlet（Server Applet：服务器端的Java小程序）
  - JSP
  - AJAX
  - jQuery
  - MyBatis
  - Spring
  - SpringMVC
  - SpringBoot
  - SpringCloud
  - ......

# Typora软件介绍

- Markdown文本编辑器（可以编辑xxx.md文件）

  ```java
  public class Test{
      public static void main(String[] args){
          System.out.println("Test code!");
      }
  }
  ```


  













## 在集成开发环境当中开发Servlet程序

- 集成开发工具很多，其中目前使用比较多的是：

  - IntelliJ IDEA（这个居多，IDEA在提示功能方面要强于Eclipse，也就是说IDEA使用起来比Eclipse更加智能，更好用。JetBrain公司开发的。收费的。）
  - Eclipse（这个少一些），Eclipse目前还是有团队使用，只不过处于减少的趋势，自己从事工作之后，可能会遇到。Eclipse是IBM团队开发的。Eclipse寓意是“日食”。“日食”表示将太阳吃掉。太阳是SUN。IBM团队开发Eclipse的寓意是吞并SUN公司，但是2009年的时候SUN公司被Oracle公司并购了。IBM并没有成功并购SUN公司。

- 使用IDEA集成开发工具开发Servlet

  - 第一步：New Project（我比较习惯先创建一个Empty Project【空工程】，然后在空工程下新建Module【模块】，这不是必须的，只是一种习惯，你可以直接新建非空的Project），这个Empty Project起名为：javaweb（不是必须的，只是一个名字而已。一般情况下新建的Project的名字最好和目录的名字一致。）
  - 第二步：新建模块（File --> new --> Module...）
    - 这里新建的是一个普通的JavaSE模块（这里先不要新建Java Enterprise模块）
    - 这个Module自动会被放在javaweb的project下面。
    - 这个Module起名：servlet01
  - 第三步：让Module变成JavaEE的模块。（让Module变成webapp的模块。符合webapp规范。符合Servlet规范的Module）
    - 在Module上点击右键：Add Framework Support...（添加框架支持）
    - 在弹出的窗口中，选择Web Application（选择的是webapp的支持）
    - 选择了这个webapp的支持之后，IDEA会自动给你生成一个符合Servlet规范的webpp目录结构。
    - **重点，需要注意的：在IDEA工具中根据Web Application模板生成的目录中有一个web目录，这个目录就代表webapp的根**
  - 第四步（非必须）：根据Web Application生成的资源中有index.jsp文件，这里我选择删除这个index.jsp文件。
  - 第五步：编写Servlet（StudentServlet）
    - class StudentServlet implements Servlet
    - 这个时候发现Servlet.class文件没有。怎么办？将CATALINA_HOME/lib/servlet-api.jar和jsp-api.jar添加到classpath当中（这里的classpath说的是IDEA的classpath）
      - File --> Project Structrue --> Modules --> + 加号 --> Add JARS....
    - 实现jakarta.servlet.Servlet接口中的5个方法。
  - 第六步：在Servlet当中的service方法中编写业务代码（我们这里连接数据库了。）
  - 第七步：在WEB-INF目录下新建了一个子目录：lib（这个目录名可不能随意，必须是全部小写的lib），并且将连接数据库的驱动jar包放到lib目录下。
  - 第八步：在web.xml文件中完成StudentServlet类的注册。（请求路径和Servlet之间对应起来）

  ```java
  <?xml version="1.0" encoding="UTF-8"?>
  <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
           version="4.0">
  
      <servlet>
          <servlet-name>studentServlet</servlet-name>
          <servlet-class>com.bjpowernode.javaweb.servlet.StudentServlet</servlet-class>
      </servlet>
      <servlet-mapping>
          <servlet-name>studentServlet</servlet-name>
          <url-pattern>/servlet/student</url-pattern>
      </servlet-mapping>
      
  </web-app>
  ```

  

  - 第九步：给一个html页面，在HTML页面中编写一个超链接，用户点击这个超链接，发送请求，Tomcat执行后台的StudentServlet。

    - student.html

    - 这个文件不能放到WEB-INF目录里面，只能放到WEB-INF目录外面。

    - student.html文件的内容

    - ```html
      <!DOCTYPE html>
      <html lang="en">
      <head>
          <meta charset="UTF-8">
          <title>student page</title>
      </head>
      <body>
          <!--这里的项目名是 /xmm ，无法动态获取，先写死-->
          <a href="/xmm/servlet/student">student list</a>
      </body>
      </html>
      ```

      

  - 第十步：让IDEA工具去关联Tomcat服务器。关联的过程当中将webapp部署到Tomcat服务器当中。

    - IDEA工具右上角，绿色小锤子右边有一个：Add Configuration
    - 左上角加号，点击Tomcat Server --> local
    - 在弹出的界面中设置服务器Server的参数（基本上不用动）
    - 在当前窗口中有一个Deployment（点击这个用来部署webapp），继续点击加号，部署即可。
    - 修改 Application context为：/xmm

  - 第十一步：启动Tomcat服务器

    - 在右上角有绿色的箭头，或者绿色的小虫子，点击这个绿色的小虫子，可以采用debug的模式启动Tomcat服务器。
    - 我们开发中建议适用debug模式启动Tomcat

  - 第十二步：打开浏览器，在浏览器地址栏上输入：http://localhost:8080/xmm/student.html



## GenericServlet

- 我们编写一个Servlet类直接实现Servlet接口有什么缺点？

  - 我们只需要service方法，其他方法大部分情况下是不需要使用的。代码很丑陋。

- 适配器设计模式Adapter

  - 手机直接插到220V的电压上，手机直接就报废了。怎么办？可以找一个充电器。这个充电器就是一个适配器。手机连接适配器。适配器连接220V的电压。这样问题就解决了。

- 编写一个GenericServlet类，这个类是一个抽象类，其中有一个抽象方法service。

  - GenericServlet实现Servlet接口。
  - GenericServlet是一个适配器。
  - 以后编写的所有Servlet类继承GenericServlet，重写service方法即可。

- 思考：GenericServlet类是否需要改造一下？怎么改造？更利于子类程序的编写？

  - 思考第一个问题：我提供了一个GenericServlet之后，init方法还会执行吗？

    - 还会执行。会执行GenericServlet类中的init方法。

  - 思考第二个问题：init方法是谁调用的？

    - Tomcat服务器调用的。

  - 思考第三个问题：init方法中的ServletConfig对象是谁创建的？是谁传过来的？

    - 都是Tomcat干的。
    - Tomcat服务器先创建了ServletConfig对象，然后调用init方法，将ServletConfig对象传给了init方法。

  - 思考一下Tomcat服务器伪代码：

    - ```java
      public class Tomcat {
          public static void main(String[] args){
              // .....
              // Tomcat服务器伪代码
              // 创建LoginServlet对象（通过反射机制，调用无参数构造方法来实例化LoginServlet对象）
              Class clazz = Class.forName("com.bjpowernode.javaweb.servlet.LoginServlet");
              Object obj = clazz.newInstance();
              
              // 向下转型
              Servlet servlet = (Servlet)obj;
              
              // 创建ServletConfig对象
              // Tomcat服务器负责将ServletConfig对象实例化出来。
              // 多态（Tomcat服务器完全实现了Servlet规范）
              ServletConfig servletConfig = new org.apache.catalina.core.StandardWrapperFacade();
              
              // 调用Servlet的init方法
              servlet.init(servletConfig);
              
              // 调用Servlet的service方法
              // ....
              
          }
      }
      ```

## 模板方法设计模式

- 什么是设计模式？
  - 某个问题的固定的解决方案。(可以被重复使用。)
- 你知道哪些设计模式？
  - GoF设计模式：
    - 通常我们所说的23种设计模式。（Gang of Four：4人组提出的设计模式）
    - 单例模式
    - 工厂模式
    - 代理模式
    - 门面模式
    - 责任链设计模式
    - 观察者模式
    - 模板方法设计模式
    - .....
  - JavaEE设计模式：
    - DAO
    - DTO
    - VO
    - PO
    - pojo
    - ....
  - ....
- 什么是模板方法设计模式
  - 在模板类的模板方法当中定义核心算法骨架，具体的实现步骤可以延迟到子类当中完成。
- 模板类通常是一个抽象类，模板类当中的模板方法定义核心算法，这个方法通常是final的（但也可以不是final的）
- 模板类当中的抽象方法就是不确定实现的方法，这个不确定怎么实现的事儿交给子类去做。

## 关于WEB-INF目录

- 在WEB-INF目录下新建了一个文件：welcome.html
- 打开浏览器访问：http://localhost:8080/servlet07/WEB-INF/welcome.html 出现了404错误。
- 注意：放在WEB-INF目录下的资源是受保护的。在浏览器上不能够通过路径直接访问。所以像HTML、CSS、JS、image等静态资源一定要放到WEB-INF目录之外



## 分析使用纯粹Servlet开发web应用的缺陷

- 在Servlet当中编写HTML/CSS/JavaScript等前端代码。存在什么问题？
  - java程序中编写前端代码，编写难度大。麻烦。
  - java程序中编写前端代码，显然程序的耦合度非常高。
  - java程序中编写前端代码，代码非常不美观。
  - java程序中编写前端代码，维护成本太高。（非常难于维护）
    - 修改小小的一个前端代码，只要有改动，就需要重新编译java代码，生成新的class文件，打一个新的war包，重新发布。
- 思考一下，如果是你的话，你准备怎么解决这个问题？
  - 思路很重要。使用什么样的思路去做、去解决这个问题
    - 上面的那个Servlet（Java程序）能不能不写了，让机器自动生成。我们程序员只需要写这个Servlet程序中的“前端的那段代码”，然后让机器将我们写的“前端代码”自动翻译生成“Servlet这种java程序”。然后机器再自动将“java”程序编译生成"class"文件。然后再使用JVM调用这个class中的方法。

- Cookie禁用了，session还能找到吗？

  - cookie禁用是什么意思？服务器正常发送cookie给浏览器，但是浏览器不要了。拒收了。并不是服务器不发了。
  - 找不到了。每一次请求都会获取到新的session对象。
  - cookie禁用了，session机制还能实现吗？
    - 可以。需要使用URL重写机制。
    - http://localhost:8080/servlet12/test/session;jsessionid=19D1C99560DCBF84839FA43D58F56E16
    - URL重写机制会提高开发者的成本。开发人员在编写任何请求路径的时候，后面都要添加一个sessionid，给开发带来了很大的难度，很大的成本。所以大部分的网站都是这样设计的：你要是禁用cookie，你就别用了。

- 总结一下到目前位置我们所了解的域对象：

  - request（对应的类名：HttpServletRequest）
    - 请求域（请求级别的）
  - session（对应的类名：HttpSession）
    - 会话域（用户级别的）
  - application（对应的类名：ServletContext）
    - 应用域（项目级别的，所有用户共享的。）
  - 这三个域对象的大小关系
    - request < session < application
  - 他们三个域对象都有以下三个公共的方法：
    - setAttribute（向域当中绑定数据）
    - getAttribute（从域当中获取数据）
    - removeAttribute（删除域当中的数据）
  - 使用原则：尽量使用小的域。

- session掌握之后，我们怎么解决oa项目中的登录问题，怎么能让登录起作用。

  - 登录成功之后，可以将用户的登录信息存储到session当中。也就是说session中如果有用户的信息就代表用户登录成功了。session中没有用户信息，表示用户没有登录过。则跳转到登录页面。

- 销毁session对象：

  - ```java
    session.invalidate();
    ```

## Cookie

- session的实现原理中，每一个session对象都会关联一个sessionid，例如：
  - JSESSIONID=41C481F0224664BDB28E95081D23D5B8
  - 以上的这个键值对数据其实就是cookie对象。
  - 对于session关联的cookie来说，这个cookie是被保存在浏览器的“运行内存”当中。
  - 只要浏览器不关闭，用户再次发送请求的时候，会自动将运行内存中的cookie发送给服务器。
  - 例如，这个Cookie: JSESSIONID=41C481F0224664BDB28E95081D23D5B8就会再次发送给服务器。
  - 服务器就是根据41C481F0224664BDB28E95081D23D5B8这个值来找到对应的session对象的。
  
- cookie怎么生成？cookie保存在什么地方？cookie有啥用？浏览器什么时候会发送cookie，发送哪些cookie给服务器？？？？？？？

- cookie最终是保存在浏览器客户端上的。

  - 可以保存在运行内存中。（浏览器只要关闭cookie就消失了。）
  - 也可以保存在硬盘文件中。（永久保存。）

- cookie有啥用呢？

  - cookie和session机制其实都是为了保存会话的状态。
  - cookie是将会话的状态保存在浏览器客户端上。（cookie数据存储在浏览器客户端上的。）
  - session是将会话的状态保存在服务器端上。（session对象是存储在服务器上。）
  - 为什么要有cookie和session机制呢？因为HTTP协议是无状态 无连接协议。

- cookie的经典案例

  - 京东商城，在未登录的情况下，向购物车中放几件商品。然后关闭商城，再次打开浏览器，访问京东商城的时候，购物车中的商品还在，这是怎么做的？我没有登录，为什么购物车中还有商品呢？
    - 将购物车中的商品编号放到cookie当中，cookie保存在硬盘文件当中。这样即使关闭浏览器。硬盘上的cookie还在。下一次再打开京东商城的时候，查看购物车的时候，会自动读取本地硬盘中存储的cookie，拿到商品编号，动态展示购物车中的商品。
      - 京东存储购物车中商品的cookie可能是这样的：productIds=xxxxx,yyyy,zzz,kkkk
      - 注意：cookie如果清除掉，购物车中的商品就消失了。
  - 126邮箱中有一个功能：十天内免登录
    - 这个功能也是需要cookie来实现的。
    - 怎么实现的呢？
      - 用户输入正确的用户名和密码，并且同时选择十天内免登录。登录成功后。浏览器客户端会保存一个cookie，这个cookie中保存了用户名和密码等信息，这个cookie是保存在硬盘文件当中的，十天有效。在十天内用户再次访问126的时候，浏览器自动提交126的关联的cookie给服务器，服务器接收到cookie之后，获取用户名和密码，验证，通过之后，自动登录成功。
      - 怎么让cookie失效？
        - 十天过后自动失效。
        - 或者改密码。
        - 或者在客户端浏览器上清除cookie。

- cookie机制和session机制其实都不属于java中的机制，实际上cookie机制和session机制都是HTTP协议的一部分。php开发中也有cookie和session机制，只要是你是做web开发，不管是什么编程语言，cookie和session机制都是需要的。

- HTTP协议中规定：任何一个cookie都是由name和value组成的。name和value都是字符串类型的。

- 在java的servlet中，对cookie提供了哪些支持呢？

  - 提供了一个Cookie类来专门表示cookie数据。jakarta.servlet.http.Cookie;
  - java程序怎么把cookie数据发送给浏览器呢？response.addCookie(cookie);

- 在HTTP协议中是这样规定的：当浏览器发送请求的时候，会自动携带该path下的cookie数据给服务器。（URL。）

- 关于cookie的有效时间

  - 怎么用java设置cookie的有效时间
    - cookie.setMaxAge(60 * 60); 设置cookie在一小时之后失效。
  - 没有设置有效时间：默认保存在浏览器的运行内存中，浏览器关闭则cookie消失。
  - 只要设置cookie的有效时间 > 0，这个cookie一定会存储到硬盘文件当中。
  - 设置cookie的有效时间 = 0 呢？
    - cookie被删除，同名cookie被删除。
  - 设置cookie的有效时间 < 0 呢？
    - 保存在运行内存中。和不设置一样。

- 关于cookie的path，cookie关联的路径：

  - 假设现在发送的请求路径是“http://localhost:8080/servlet13/cookie/generate”生成的cookie，如果cookie没有设置path，默认的path是什么？
    - 默认的path是：http://localhost:8080/servlet13/cookie 以及它的子路径。
    - 也就是说，以后只要浏览器的请求路径是http://localhost:8080/servlet13/cookie 这个路径以及这个路径下的子路径，cookie都会被发送到服务器。
  - 手动设置cookie的path
    - cookie.setPath(“/servlet13”); 表示只要是这个servlet13项目的请求路径，都会提交这个cookie给服务器。

- 浏览器发送cookie给服务器了，服务器中的java程序怎么接收？

  - ```java
    Cookie[] cookies = request.getCookies(); // 这个方法可能返回null
    if(cookies != null){
        for(Cookie cookie : cookies){
            // 获取cookie的name
            String name = cookie.getName();
            // 获取cookie的value
            String value = cookie.getValue();
        }
    }
    
    ```

- 使用cookie实现一下十天内免登录功能。

  - 先实现登录功能
    - 登录成功
      - 跳转到部门列表页面
    - 登录失败
      - 跳转到登录失败页面
  - 修改前端页面
    - 在登录页面给一个复选框，复选框后面给一句话：十天内免登录。
    - 用户选择了复选框：表示要支持十天内免登录。
    - 用户没有选择复选框：表示用户不想使用十天内免登录功能。
  - 修改Servlet中的login方法
    - 如果用户登录成功了，并且用户登录时选择了十天内免登录功能，这个时候应该在Servlet的login方法中创建cookie，用来存储用户名和密码，并且设置路径，设置有效期，将cookie响应给浏览器。（浏览器将其自动保存在硬盘文件当中10天）
  - 用户再次访问该网站的时候，访问这个网站的首页的时候，有两个走向:
    - 要么跳转到部门列表页面
    - 要么跳转到登录页面
    - 以上分别有两个走向，这显然是需要编写java程序进行控制的。


# JSTL标签库

- 什么是JSTL标签库？

  - Java Standard Tag Lib（Java标准的标签库）
  - JSTL标签库通常结合EL表达式一起使用。目的是让JSP中的java代码消失。
  - 标签是写在JSP当中的，但实际上最终还是要执行对应的java程序。（java程序在jar包当中。）

- 使用JSTL标签库的步骤：

  - 第一步：引入JSTL标签库对应的jar包。

    - tomcat10之后引入的jar包是：
      - jakarta.servlet.jsp.jstl-2.0.0.jar
      - jakarta.servlet.jsp.jstl-api-2.0.0.jar
    - 在IDEA当中怎么引入？
      - 在WEB-INF下新建lib目录，然后将jar包拷贝到lib当中。然后将其“Add Lib...”
      - 一定是要和mysql的数据库驱动一样，都是放在WEB-INF/lib目录下的。
      - 什么时候需要将jar包放到WEB-INF/lib目录下？如果这个jar是tomcat服务器没有的。
    
  - 第二步：在JSP中引入要使用标签库。（使用taglib指令引入标签库。）
  
    - JSTL提供了很多种标签，你要引入哪个标签？？？？重点掌握核心标签库。
  
    - ```
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      这个就是核心标签库。
      prefix="这里随便起一个名字就行了，核心标签库，大家默认的叫做c，你随意。"
      ```
  
  - 第三步：在需要使用标签的位置使用即可。表面使用的是标签，底层实际上还是java程序。
  
- JSTL标签的原理

  - ```
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    以上uri后面的路径实际上指向了一个xxx.tld文件。
    tld文件实际上是一个xml配置文件。
    在tld文件中描述了“标签”和“java类”之间的关系。
    以上核心标签库对应的tld文件是：c.tld文件。它在哪里。
    在jakarta.servlet.jsp.jstl-2.0.0.jar里面META-INF目录下，有一个c.tld文件。
    ```

  - 源码解析：配置文件tld解析

    - ```
      <tag>
          <description>对该标签的描述</description>
          <name>catch</name> 标签的名字
          <tag-class>org.apache.taglibs.standard.tag.common.core.CatchTag</tag-class> 标签对应的java类。
          <body-content>JSP</body-content> 标签体当中可以出现的内容，如果是JSP，就表示标签体中可以出现符合JSP所有语法的代码。例如EL表达式。
          <attribute>
              <description>
              	对这个属性的描述
              </description>
              <name>var</name> 属性名
              <required>false</required> false表示该属性不是必须的。true表示该属性是必须的。
              <rtexprvalue>false</rtexprvalue> 这个描述说明了该属性是否支持EL表达式。false表示不支持。true表示支持EL表达式。
          </attribute>
        </tag>
      
      <c:catch var="">
      	JSP....
      </c:catch>
      ```
    
  - jstl中的核心标签库core当中有哪些常用的标签呢？
  
    - c:if
  
      - <c:if test="boolean类型，支持EL表达式"></c: if>
  
    - c:forEach
  
      - <c:forEach items="集合，支持EL表达式" var="集合中的元素" varStatus="元素状态对象"> ${元素状态对象.count} </c: forEach>
      - <c:forEach var="i" begin="1" end="10" step="2"> ${i} </c: forEach>
  
    - c:choose c:when c:otherwise
  
      - ```
        <c:choose>
            <c:when test="${param.age < 18}">
                青少年
            </c:when>
            <c:when test="${param.age < 35}">
                青年
            </c:when>
            <c:when test="${param.age < 55}">
                中年
            </c:when>
            <c:otherwise>
                老年
            </c:otherwise>
        </c:choose>
        ```

## 改造OA

- 使用什么技术改造呢？

  - Servlet + JSP + EL表达式 + JSTL标签。进行改造。

- 在前端HTML代码中，有一个标签，叫做base标签，这个标签可以设置整个网页的基础路径。

  - 这是Java的语法，也不是JSP的语法。是HTML中的一个语法。HTML中的一个标签。通常出现在head标签中。

  - < base href="http://localhost:8080/oa/">

  - 在当前页面中，凡是路径没有以“/”开始的，都会自动将base中的路径添加到这些路径之前。

    - < a href="ab/def"></ a>
    - 等同于：< a href="http://localhost:8080/oa/ab/def"></ a>

  - 需要注意：在JS代码中的路径，保险起见，最好不要依赖base标签。JS代码中的路径最好写上全路径。

  - ```
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    ```



# Listener监听器

- 什么是监听器？

  - 监听器是Servlet规范中的一员。就像Filter一样。Filter也是Servlet规范中的一员。
  - 在Servlet中，所有的监听器接口都是以“Listener”结尾。

- 监听器有什么用？

  - 监听器实际上是Servlet规范留给我们javaweb程序员的特殊时机。
  - 特殊的时刻如果想执行这段代码，你需要想到使用对应的监听器。

- Servlet规范中提供了哪些监听器？

  - jakarta.servlet包下：
    - ServletContextListener
    - ServletContextAttributeListener
    - ServletRequestListener
    - ServletRequestAttributeListener
  - jakarta.servlet.http包下：
    - HttpSessionListener
    - HttpSessionAttributeListener
      - 该监听器需要使用@WebListener注解进行标注。
      - 该监听器监听的是什么？是session域中数据的变化。只要数据变化，则执行相应的方法。主要监测点在session域对象上。
    - HttpSessionBindingListener
      - 该监听器不需要使用@WebListener进行标注。
      - 假设User类实现了该监听器，那么User对象在被放入session的时候触发bind事件，User对象从session中删除的时候，触发unbind事件。
      - 假设Customer类没有实现该监听器，那么Customer对象放入session或者从session删除的时候，不会触发bind和unbind事件。
    - HttpSessionIdListener
      - session的id发生改变的时候，监听器中的唯一一个方法就会被调用。
    - HttpSessionActivationListener
      - 监听session对象的钝化和活化的。
      - 钝化：session对象从内存存储到硬盘文件。
      - 活化：从硬盘文件把session恢复到内存。

- 实现一个监听器的步骤：以ServletContextListener为例。

  - 第一步：编写一个类实现ServletContextListener接口。并且实现里面的方法。

    - ```
      void contextInitialized(ServletContextEvent event)
      void contextDestroyed(ServletContextEvent event)
      ```

  - 第二步：在web.xml文件中对ServletContextListener进行配置，如下：

    - ```
      <listener>
          <listener-class>com.bjpowernode.javaweb.listener.MyServletContextListener</listener-class>
      </listener>
      ```

    - 当然，第二步也可以不使用配置文件，也可以用注解，例如：@WebListener
  
- 注意：所有监听器中的方法都是不需要javaweb程序员调用的，由服务器来负责调用？什么时候被调用呢？

  - 当某个特殊的事件发生（特殊的事件发生其实就是某个时机到了。）之后，被web服务器自动调用。
  
- 思考一个业务场景：

  - 请编写一个功能，记录该网站实时的在线用户的个数。
  - 我们可以通过服务器端有没有分配session对象，因为一个session代表了一个用户。有一个session就代表有一个用户。如果你采用这种逻辑去实现的话，session有多少个，在线用户就有多少个。这种方式的话：HttpSessionListener够用了。session对象只要新建，则count++，然后将count存储到ServletContext域当中，在页面展示在线人数即可。
  - 业务发生改变了，只统计登录的用户的在线数量，这个该怎么办？
    - session.setAttribute("user", userObj); 
    - 用户登录的标志是什么？session中曾经存储过User类型的对象。那么这个时候可以让User类型的对象实现HttpSessionBindingListener监听器，只要User类型对象存储到session域中，则count++，然后将count++存储到ServletContext对象中。页面展示在线人数即可。

- 实现oa项目中当前登录在线的人数。

  - 什么代表着用户登录了？
    - session.setAttribute("user", userObj); User类型的对象只要往session中存储过，表示有新用户登录。
  - 什么代表着用户退出了？
    - session.removeAttribute("user"); User类型的对象从session域中移除了。
    - 或者有可能是session销毁了。（session超时）

























