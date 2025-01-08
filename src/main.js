import Vue from 'vue';
import App from './App.vue'
import Store from './vuex/store';
Vue.config.productionTip = false;

new Vue({
  el : '#app',
  render : h => h(App),
  store : Store
});