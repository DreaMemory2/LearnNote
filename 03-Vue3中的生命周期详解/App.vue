<template>
  <h1>App Vue3</h1>
  <button @click="display = !display">显示 & 隐藏</button>
  <Tool v-if="display"></Tool>
</template>

<script>
  import { ref } from 'vue';
  import Tool from './components/Tool.vue';
  export default {
    /* 直接在大括号当中进行的配置，叫做：选项式API */
    name : 'AppComponent',
    components : {Tool},
    /* 在setup函数体当中进行的配置使用的API，叫做：组合式API */
    setup(props) {
      // data
      let display = ref(true);
      // methods
      let isDisplay = function() {
        return display = !display;
      };
      return {isDisplay, display};
    }
  }
</script>