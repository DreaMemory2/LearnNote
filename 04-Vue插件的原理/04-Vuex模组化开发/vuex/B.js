/* B模块 */
export default {
  /* 开启命名空间 */
  namespaced : true,
  actions : {
    doB1() {
      alert('DoB1 Action');
    }
  },
  mutations : {
    doB2() {
      alert('DoB2 Mutation...');
    }
  },
  state : {
    b : 2
  },
  getters : {
    B() {
      return 2;
    }
  }
};