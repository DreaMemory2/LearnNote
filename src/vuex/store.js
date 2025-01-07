// 引入Vue，因为需要使用Vuex插件的时候需要Vue
import Vue from 'vue';
// 引入Vuex插件
import Vuex from 'vuex';

// 使用插件
Vue.use(Vuex);

// 创建三个对象: actions对象、mutations对象、state对象
const actions = {};
const mutations = {};
const state = {};

// 创建store对象(这个store对象是vuex插件中最核心的对象)
const store = new Vuex.Store({
  // 它是一个负责执行某个行为的对象
  actions : actions,
  // 它是一个负责更新的对象
  mutations : mutations,
  // 它是一个状态对象
  state : state
});

// 导出store对象(暴露对象)
export default store;