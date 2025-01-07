import Vue from 'vue'
import App from './App.vue'

// 导入插件
import {plugin} from './plugins.js';

Vue.config.productionTip = false;

// 插件的使用通常放在创建Vue实例之前
// 即可以插入，也可以拔下插件
Vue.use(plugin);

new Vue({
  el : '#app',
  render: createElement => createElement(App)
});
