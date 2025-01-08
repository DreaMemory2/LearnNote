// 引入Vue，因为需要使用Vuex插件的时候需要Vue
import Vue from 'vue';
// 引入Vuex插件
import Vuex from 'vuex';

// 使用插件
Vue.use(Vuex);

// 创建三个对象: actions对象、mutations对象、state对象
const actions = {
  // N多个action, 每一个action都是一个callback回调函数
  /* 
    在action这种回调函数中编写复杂业务逻辑, 或者说发送AJAX请求
    context参数: context是vuex的上下文, 可以看作store对象的缩小版
    value参数: 传过来的数据
  */
  addNumber(context, value) {
    // 业务逻辑
    value = value + 1;
    //调用其他的action这个回调函数
    context.dispatch('otherAction', value);
    // 业务逻辑处理完成之后，继续向下一个环节，轮到数据的更新
    // 提交上下文环境
    context.commit('ADD_NUMBER', value);
  },

  /* 其他action逻辑 */
  otherAction() {
    console.log('继续分发dispacth');
  }
};
const mutations = {
  // N多个mutation, 每一个mutation都是一个callback回调函数
  /* 
    每一个mutation这个回调函数的作用就是: 更新state
    只要state更新，因为是响应式的，所以页面就重新渲染
    state: 更新对象
    value: 上一节传过来的数据
  */
  ADD_NUMBER(state, value) {
    state.number += value;
  }
};

// 等同于Vue当中的data(状态)
const state = {
  number : 0
};

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