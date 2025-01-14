<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>AJAX中的Get请求</title>
</head>
<body>
<%-- 熟悉AJAX中的四步骤 --%>
  <%-- 动态输入数据 --%>
  金属锭: <input type="text" id="ingot"/>
  金属剑: <input type="text" id="sword"/>
  <input type="button" value="hello" id="button"/>
  <div id="container"></div>

  <script type="text/javascript">
    window.onload = function (){
      document.getElementById('button').onclick = function (){
        // 1. 创建AJAX核心对象
        let request = new XMLHttpRequest();
        // 2. 注册回调函数
        request.onreadystatechange = function (){
          if (this.readyState === 4) {
            if (this.status === 200) {
              document.getElementById('container').innerHTML = this.responseText;
            }
          }
        };
        // 3. 开启通道
        let ingot = document.getElementById('ingot').value;
        let sword = document.getElementById('sword').value;
        request.open('GET', "/web/test02?ingot=" + ingot + "&sword=" + sword, true);
        // 4. 发生请求
        request.send();
      }
    }
  </script>
</body>
</html>
