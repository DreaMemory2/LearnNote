<template>
  <!-- 触发color事件 -->
  <button @click="getColor">获取颜色</button>
  <RedWool/>
</template>

<script>
/* 导入全局事件总线对象 */
import emitter from '../utils/event-bus';
/* 引入组合式API，生命周期钩子 */
import {onMounted} from 'vue';
import RedWool from './RedWool.vue';
export default {
  name : 'Wool',
  components : { RedWool },
  /* context代表组件上下文对象 */
  setup(props, context) {
    /* data */

    /* lifecycle */
    // 挂载完成时期
    onMounted(() => {
      // 给全局事件总线绑定事件
      emitter.on('redColor', getRedColor);
    });

    /* methods */
    function getColor() {
      /* 触发事件 */
      context.emit('color', '白色');
    };
    function getRedColor(wool) {
      alert(wool.color);
    };

    /* 返回一个对象 */
    return {getColor, getRedColor};
  }
}
</script>

<style>

</style>