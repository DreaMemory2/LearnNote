/* A模块 */
export default {
  /* 开启命名空间 */
  namespaced : true,
  actions : {
    doA1() {
      alert('DoA1 Action...');
    }
  },
  mutations : {
    doA2() {
      alert('DoA2 Mutation...');
    }
  },
  state : {
    a : 1
  },
  getters : {
    A() {
      return 1;
    }
  }
};