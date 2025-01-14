1. 在AJAX的请求，以及AJAX接收服务器的响应，完全都是依靠XmlHttpRequest对象的
    - XmlHttpRequest对象中的readyState属性记录下了XmlHttpRequest对象的状态
2. XmlHttpRequest对象的readyState属性对应的状态值
    - 0: 请求未初始化 
    - 1: 服务器连接已建立
    - 2: 请求已收到 
    - 3: 正在处理请求 
    - 4: 请求已完成目响应已就绪
3. 当XmlHttpRequest对象的readyState属性的值变成4的时候表示这个AJAX请求以及响应已经全部完成了