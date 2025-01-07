<template>
  <div>
  </div>
</template>

<script>
  import pubsub from 'pubsub-js';
  export default {
    name : 'AComponent',
    mounted() {
      // A组件挂载完毕之后，订阅消息
      this.pid = pubsub.subscribe('2023年第5期英语周报', (title, message) => {
        // title消息的标题，message消息的内容
        console.log('消息名字是: ', title);
        console.log('消息数据是: ', message);
        /* 建议使用箭头函数，指向vc实例 */
        console.log(this);
      });
    },
    beforeDestroy() {
      // 当前组件实例销毁之前，要取消之前订阅的所有消息
      pubsub.unsubscribe(this.pid);
    }
  }
</script>