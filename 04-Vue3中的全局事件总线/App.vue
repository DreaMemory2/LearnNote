<template>
  <h1>App Vue3</h1>
  <!-- 给这个组件绑定自定义事件 -->
  <Wool @color="getColor" />
</template>

<script>
  import Wool from './components/Wool.vue';
  export default {
    name : 'App',
    components : { Wool },
    setup() {
      /* methods */
      function getColor(color) {
        alert("颜色为: " + color);
      }
      // 返回一个对象
      return {getColor}
    }
  }
</script>