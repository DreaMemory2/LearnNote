/* 等同于引入Vue.js文件 */
import Vue from 'vue'
/* 引入App组件(根组件) */
import App from './App.vue'

/* 关闭生产提示信息 */
Vue.config.productionTip = false

new Vue({
  el : '#app',
  /* 您正在使用Vue的仅运行时的版本，其中模板编译器不可用 */
  /* 采用缺失模板编译器vue.js，目的减小体积
      - Vue.js包括两块：Vue的核心、模板编译器(占用比33%)
     使用webpack进行打包处理之后，模板编译器就没有存在的必要
  */
  /* 这个函数被调用的时候会自动传入过来一个参数：createElement
      createElement用来创建元素
  */
  /* render(createElement) {
    return createElement(App);
  } */
  render: createElement => createElement(App)
});
