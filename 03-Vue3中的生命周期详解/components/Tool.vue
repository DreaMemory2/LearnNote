<template>
  <h1>组件显示与隐藏</h1>
  <h3>{{couter}}</h3>
  <button @click="couter++">自加一</button>
</template>

<script>
import { ref } from 'vue'
export default {
  name : 'Tool',
  /* 在Vue3当中，生命周期钩子函数有两种写法
     1. 第一种写法：选项式API
     2. 第二种写法：组合式API
  */
  setup() {
    // data
    let couter = ref(0);
    // methods
    let addNumber = function() {
      return couter++;
    };
    console.log('安装组合式API');
    // 返回一个对象
    return {couter, addNumber};
  },
  beforeCreate() {
    console.log('正在初始化选项式API');
  },
  created() {
    console.log('完成初始化选项式API');
  },
  beforeMount() {
    console.log('正在组件挂载阶段');
  },
  mounted() {
    console.log('完成组件挂载阶段');
  },
  beforeUpdate() {
    console.log('正在组件更新阶段');
  },
  updated() {
    console.log('完成组件更新阶段');
  },
  beforeUnmount() {
    console.log('正在组件卸载阶段');
  },
  unmounted() {
    console.log('完成组件卸载阶段');
  }
}
</script>