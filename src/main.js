import Vue from 'vue'
import App from './App.vue'
Vue.config.productionTip = false

// 引入Vuex插件中的核心对象store
import store from './vuex/store';

new Vue({
  el : '#app',
  render: h => h(App),
  // 全新的配置项: store
  /* 加上这个配置项之后，vm以及所有的vc对象上都会多一个属性：$store */
  store : store
});