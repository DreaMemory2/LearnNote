## 使用纯Servlet做一个单表的CRUD操作

- 使用纯粹的Servlet完成单表【对部门的】的增删改查操作。（B/S结构的。）

- 实现步骤

    - 第一步：准备一张数据库表。（sql脚本）

        - ```sql
      # 部门表
      drop table if exists dept;
      create table dept(
      	deptno int primary key,
          dname varchar(255),
          loc varchar(255)
      );
      insert into dept(deptno, dname, loc) values(10, 'XiaoShouBu', 'BEIJING');
      insert into dept(deptno, dname, loc) values(20, 'YanFaBu', 'SHANGHAI');
      insert into dept(deptno, dname, loc) values(30, 'JiShuBu', 'GUANGZHOU');
      insert into dept(deptno, dname, loc) values(40, 'MeiTiBu', 'SHENZHEN');
      commit;
      select * from dept;
      ```

    - 第二步：准备一套HTML页面（项目原型）【前端开发工具使用HBuilder】

        - 把HTML页面准备好
        - 然后将HTML页面中的链接都能够跑通。（页面流转没问题。）
        - 应该设计哪些页面呢？
            - 欢迎页面：index.html
            - 列表页面：list.html（以列表页面为核心，展开其他操作。）
            - 新增页面：add.html
            - 修改页面：edit.html
            - 详情页面：detail.html

    - 第三步：分析我们这个系统包括哪些功能？

        - 什么叫做一个功能呢？
            - 只要 这个操作连接了数据库，就表示一个独立的功能。
        - 包括哪些功能？
            - 查看部门列表
            - 新增部门
            - 删除部门
            - 查看部门详细信息
            - 跳转到修改页面
            - 修改部门

    - 第四步：在IDEA当中搭建开发环境

        - 创建一个webapp（给这个webapp添加servlet-api.jar和jsp-api.jar到classpath当中。）
        - 向webapp中添加连接数据库的jar包（mysql驱动）
            - 必须在WEB-INF目录下新建lib目录，然后将mysql的驱动jar包拷贝到这个lib目录下。这个目录名必须叫做lib，全部小写的。
        - JDBC的工具类
        - 将所有HTML页面拷贝到web目录下。

    - 第五步：实现第一个功能：查看部门列表

        - 我们应该怎么去实现一个功能呢？

            - 建议：你可以从后端往前端一步一步写。也可以从前端一步一步往后端写。都可以。但是千万要记住不要想起来什么写什么。你写代码的过程最好是程序的执行过程。也就是说：程序执行到哪里，你就写哪里。这样一个顺序流下来之后，基本上不会出现什么错误、意外。
            - 从哪里开始？
                - 假设从前端开始，那么一定是从用户点击按钮那里开始的。

        - 第一：先修改前端页面的超链接，因为用户先点击的就是这个超链接。

            - ```html
        <a href="/oa/dept/list">查看部门列表</a>
        ```

        - 第二：编写web.xml文件

            - ```xml
        <servlet>
            <servlet-name>list</servlet-name>
            <servlet-class>com.bjpowernode.oa.web.action.DeptListServlet</servlet-class>
        </servlet>
        <servlet-mapping>
            <servlet-name>list</servlet-name>
            <!--web.xml文件中的这个路径也是以“/”开始的，但是不需要加项目名-->
            <url-pattern>/dept/list</url-pattern>
        </servlet-mapping>
        ```

        - 第三：编写DeptListServlet类继承HttpServlet类。然后重写doGet方法。

            - ```java
        package com.bjpowernode.oa.web.action;
        
        import jakarta.servlet.ServletException;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;
        
        import java.io.IOException;
        
        public class DeptListServlet extends HttpServlet {
            @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
            }
        }
        ```

        - 第四：在DeptListServlet类的doGet方法中连接数据库，查询所有的部门，动态的展示部门列表页面.

            - 分析list.html页面中哪部分是固定死的，哪部分是需要动态展示的。

            - list.html页面中的内容所有的双引号要替换成单引号，因为out.print("")这里有一个双引号，容易冲突。

            - 现在写完这个功能之后，你会有一种感觉，感觉开发很繁琐，只使用servlet写代码太繁琐了。

            - ```java
        while(rs.next()){
            String deptno = rs.getString("a");
            String dname = rs.getString("dname");
            String loc = rs.getString("loc");
        
            out.print("			<tr>");
            out.print("				<td>"+(++i)+"</td>");
            out.print("				<td>"+deptno+"</td>");
            out.print("				<td>"+dname+"</td>");
            out.print("				<td>");
            out.print("					<a href=''>删除</a>");
            out.print("					<a href='edit.html'>修改</a>");
            out.print("					<a href='detail.html'>详情</a>");
            out.print("				</td>");
            out.print("			</tr>");
        }
        ```

    - 第六步：查看部门详情。

        - 建议：从前端往后端一步一步实现。首先要考虑的是，用户点击的是什么？用户点击的东西在哪里？

            - 一定要先找到用户点的“详情”在哪里。找了半天，终于在后端的java程序中找到了

                - ```html
          <a href='写一个路径'>详情</a>
          ```

                - 详情  是需要连接数据库的，所以这个超链接点击之后也是需要执行一段java代码的。所以要将这个超链接的路径修改一下。

                - 注意：修改路径之后，这个路径是需要加项目名的。"/oa/dept/detail"

            - 技巧：

                - ```java
          out.print("<a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>详情</a>");
          ```

                - 重点：向服务器提交数据的格式：uri?name=value&name=value&name=value&name=value

                - 这里的问号，必须是英文的问号。不能中文的问号。

        - 解决404的问题。写web.xml文件。

            - ```xml
        <servlet>
            <servlet-name>detail</servlet-name>
            <servlet-class>com.bjpowernode.oa.web.action.DeptDetailServlet</servlet-class>
        </servlet>
        <servlet-mapping>
            <servlet-name>detail</servlet-name>
            <url-pattern>/dept/detail</url-pattern>
        </servlet-mapping>
        ```

        - 编写一个类：DeptDetailServlet继承HttpServlet，重写doGet方法。

            - ```java
        package com.bjpowernode.oa.web.action;
        
        import jakarta.servlet.ServletException;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;
        
        import java.io.IOException;
        
        public class DeptDetailServlet extends HttpServlet {
            @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
                //中文思路（思路来源于：你要做什么？目标：查看部门详细信息。）
                // 第一步：获取部门编号
                // 第二步：根据部门编号查询数据库，获取该部门编号对应的部门信息。
                // 第三步：将部门信息响应到浏览器上。（显示一个详情。）
            }
        }
        ```

        - 在doGet方法当中：连接数据库，根据部门编号查询该部门的信息。动态展示部门详情页。

    - 第七步：删除部门

        - 怎么开始？从哪里开始？从前端页面开始，用户点击删除按钮的时候，应该提示用户是否删除。因为删除这个动作是比较危险的。任何系统在进行删除操作之前，是必须要提示用户的，因为这个删除的动作有可能是用户误操作。（在前端页面上写JS代码，来提示用户是否删除。）

            - ```html
        <a href="javascript:void(0)" onclick="del(30)" >删除</a>
        <script type="text/javascript">
        	function del(dno){
        		if(window.confirm("亲，删了不可恢复哦！")){
        			document.location.href = "/oa/dept/delete?deptno=" + dno;
        		}
        	}
        </script>
        ```

        - 以上的前端程序要写到后端的java代码当中：

            - DeptListServlet类的doGet方法当中，使用out.print()方法，将以上的前端代码输出到浏览器上。

        - 解决404的问题：

            - http://localhost:8080/oa/dept/delete?deptno=30

            - web.xml文件

                - ```xml
          <servlet>
              <servlet-name>delete</servlet-name>
              <servlet-class>com.bjpowernode.oa.web.action.DeptDelServlet</servlet-class>
          </servlet>
          <servlet-mapping>
              <servlet-name>delete</servlet-name>
              <url-pattern>/dept/delete</url-pattern>
          </servlet-mapping>
          ```

            - 编写DeptDelServlet继承HttpServlet，重写doGet方法。

            - ```java
        package com.bjpowernode.oa.web.action;
        
        import jakarta.servlet.ServletException;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;
        
        import java.io.IOException;
        
        public class DeptDelServlet extends HttpServlet {
            @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
                // 根据部门编号，删除部门。
                
            }
        }
        ```

            - 删除成功或者失败的时候的一个处理（这里我们选择了转发，并没有使用重定向机制。）

                - ```java
          // 判断删除成功了还是失败了。
          if (count == 1) {
              //删除成功
              //仍然跳转到部门列表页面
              //部门列表页面的显示需要执行另一个Servlet。怎么办？转发。
              request.getRequestDispatcher("/dept/list").forward(request, response);
          }else{
              // 删除失败
              request.getRequestDispatcher("/error.html").forward(request, response);
          }
          ```

    - 第八步：新增部门

        - 注意：最后保存成功之后，转发到 /dept/list 的时候，会出现405，为什么？
            - 第一：保存用的是post请求。底层要执行doPost方法。
            - 第二：转发是一次请求，之前是post，之后还是post，因为它是一次请求。
            - 第三：/dept/list Servlet当中只有一个doGet方法。
            - 怎么解决？两种方案
                - 第一种：在/dept/list Servlet中添加doPost方法，然后在doPost方法中调用doGet。
                - 第二种：重定向。

    - 第九步：跳转到修改部门的页面

    - 第十步：修改部门

## 在一个web应用中应该如何完成资源的跳转

- 在一个web应用中通过两种方式，可以完成资源的跳转：

    - 第一种方式：转发
    - 第二种方式：重定向

- 转发和重定向有什么区别？

    - 代码上有什么区别？

        - 转发

            - ```java
        // 获取请求转发器对象
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dept/list");
        // 调用请求转发器对象的forward方法完成转发
        dispatcher.forward(request, response);
        
        // 合并一行代码
        request.getRequestDispatcher("/dept/list").forward(request, response);
        // 转发的时候是一次请求，不管你转发了多少次。都是一次请求。
        // AServlet转发到BServlet，再转发到CServlet，再转发到DServlet，不管转发了多少次，都在同一个request当中。
        // 这是因为调用forward方法的时候，会将当前的request和response对象传递给下一个Servlet。
        ```

        - 重定向

            - ```java
        // 注意：路径上要加一个项目名。为什么？
        // 浏览器发送请求，请求路径上是需要添加项目名的。
        // 以下这一行代码会将请求路径“/oa/dept/list”发送给浏览器
        // 浏览器会自发的向服务器发送一次全新的请求：/oa/dept/list
        response.sendRedirect("/oa/dept/list");
        ```



- 形式上有什么区别？

    - 转发（一次请求）
        - 在浏览器地址栏上发送的请求是：http://localhost:8080/servlet10/a ，最终请求结束之后，浏览器地址栏上的地址还是这个。没变。
    - 重定向（两次请求）
        - 在浏览器地址栏上发送的请求是：http://localhost:8080/servlet10/a ，最终在浏览器地址栏上显示的地址是：http://localhost:8080/servlet10/b

- 转发和重定向的本质区别？

    - 转发：是由WEB服务器来控制的。A资源跳转到B资源，这个跳转动作是Tomcat服务器内部完成的。
    - 重定向：是浏览器完成的。具体跳转到哪个资源，是浏览器说了算。

- 使用一个例子去描述这个转发和重定向

    - 借钱（转发：发送了一次请求）
        - 杜老师没钱了，找张三借钱，其实张三没有钱，但是张三够义气，张三自己找李四借了钱，然后张三把这个钱给了杜老师，杜老师不知道这个钱是李四的，杜老师只求了一个人。杜老师以为这个钱就是张三的。
    - 借钱（重定向：发送了两次请求）
        - 杜老师没钱了，找张三借钱，张三没有钱，张三有一个好哥们，叫李四，李四是个富二代，于是张三将李四的家庭住址告诉了杜老师，杜老师按照这个地址去找到李四，然后从李四那里借了钱。显然杜老师在这个过程中，求了两个人。并且杜老师知道最终这个钱是李四借给俺的。

- 转发和重定向应该如何选择？什么时候使用转发，什么时候使用重定向？

    - 如果在上一个Servlet当中向request域当中绑定了数据，希望从下一个Servlet当中把request域里面的数据取出来，使用转发机制。
    - 剩下所有的请求均使用重定向。（重定向使用较多。）

- 跳转的下一个资源有没有要求呢？必须是一个Servlet吗？

    - 不一定，跳转的资源只要是服务器内部合法的资源即可。包括：Servlet、JSP、HTML.....

- 转发会存在浏览器的刷新问题。

## 将oa项目中的资源跳转修改为合适的跳转方式

- 删除之后，重定向
- 修改之后，重定向
- 保存之后，重定向
- 重定向：
    - 成功
    - 失败