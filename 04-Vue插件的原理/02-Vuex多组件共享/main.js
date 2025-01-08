import Vue from 'vue';
import App from './App.vue';
Vue.config.productionTip = false;

import Store from './vuex/store';

new Vue({
  el : '#app',
  render : h => h(App),
  store : Store
});