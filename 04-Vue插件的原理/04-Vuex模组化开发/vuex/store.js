import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

/* vuex建议: 一个功能最好一个模块 */
// 拆成A模块和B模块，对应A业务和B业务
import AModule from './A';
import BModule from './B';

export default new Vuex.Store({
  /* 模块名 : 模块 */
  modules : {AModule,BModule}
});