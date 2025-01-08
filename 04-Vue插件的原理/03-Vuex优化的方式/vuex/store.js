import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const actions = {
  saveUserInfo(context, value) {
    context.commit('SAVE_USER_INFO', {id:Date.now(), name:value});
  },
  /*
  saveVipInfo(context, value) {
    context.commit('SAVE_VIP_INFO', value);
  } 
  */
};
const mutations = {
  SAVE_USER_INFO(state, value) {
    state.users.unshift(value);
  },
  SAVE_VIP_INFO(state, value) {
    state.vips.unshift({id:Date.now(), name:value});
  }
};
const state = {
  // 可以看作Vue中的data
  username : '',
  users : [
    {id:'001', name : 'User01'},
    {id:'002', name : 'User02'},
    {id:'003', name : 'User03'}
  ],
  vips : [
    {id:'001', name:'Vip01'},
    {id:'002', name:'Vip02'},
    {id:'003', name:'Vip03'}
  ]
};

// 全新的配置项getters
const getters = {
  /* 有很多getter, 每一个getter可以看做一个计算属性
     每一个getter方法都会自动接收state对象
  */
  // 可以看作Vue中的computeds
  reverseName(state) {
    return state.username.split('').reverse().join('');
  }
};

/* 注意将getter给store */
export default new Vuex.Store({actions, mutations, state, getters});