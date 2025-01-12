1. 创建Vue3工程
   * Vue2工程创建，通过vue-cli脚手架来完成创建的
   * vue-cli脚手架是基于webpack项目构建工具实现的
   * vue3工程也可以通过vue-cli创建，也可以通过create-vue创建
   * create-vue这个脚手架是基于vite项目工具来实现的
   * vite的特点：服务器启动速度非常快，修改代码更新非常快，因此vite比webpack性能开发要好很多
2. 认识vue3工程
   * 与vue2工程类似
3. 了解vite

8. ES6新特性：window.Proxy对象
   - 通过proxy可以创建一个代理对象
   - 语法规则：
   - ```javascript
      let proxy = new Proxy({
         get(target, propertyName) {
            return target[propertyName];
         },
         set(target, propertyName, value) {
            target[propertyName] = value;
         },
         deleteProperty(target, propertyName) {
            return delete target[propertyName];
         }
      });
     ```