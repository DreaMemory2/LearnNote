<template>
  <h3>红色羊毛</h3>
  <button @click="getRedColor">获取红色</button>
  <button @click="clear">解除绑定</button>
</template>

<script>
  import emitter from '../utils/event-bus';
  export default {
    name : 'RedWool',
    setup() {
      // data
      let color = '红色';
      // methods
      function getRedColor() {
        /* 触发全局事件总线上的事件redColor */
        emitter.emit('redColor', {color : color});
      };
      function clear() {
        /* 清除总线上绑定的所有事件 */
        emitter.all.clear();
      };

      return {getRedColor, clear};
    }
  }
</script>