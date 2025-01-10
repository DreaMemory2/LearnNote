import Vue from 'vue';
import App from './App.vue'
Vue.config.productionTip = false;

/* 导入vue-router插件 */
import VueRouter from 'vue-router';
/* 使用vue-router插件 */
Vue.use(VueRouter);
/* 导入路由器对象 */
import router from './router/index'

new Vue ({
  el : '#app',
  render : h => h(App),
  /* 使用这个插件，则传递一个配置项，用来接收路由器对象 */
  router : router
});