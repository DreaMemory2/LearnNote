import Vue from 'vue';
import RouterVue from 'vue-router';
import App from './App.vue';
import router from './router/index';

Vue.config.productionTip = false;

Vue.use(RouterVue);

new Vue({
  el : '#app',
  render : h => h(App),
  router : router
});