import Vue from 'vue'
import App from './App.vue';
Vue.config.productionTip = false;

/* 获取VueComponent构造函数 */
const VueComponentConstructor = Vue.extend({});
/* 创建一个共享的vc对象 */
const globalvc = new VueComponentConstructor();
/* Vue原型对象: 给Vue原型对象扩展一个x属性，x属性指向了这个共享vc对象 */
// 给Vue原型对象扩展的这个x属性，其他的组件vc都是可以直接访问到的
Vue.prototype.globalEvent = globalvc;

new Vue({
  el : '#app',
  render : h => h(App),
  beforeCreate() {
    /* 全局事件总线 bus */
    Vue.prototype.$bus = this;
  }
});