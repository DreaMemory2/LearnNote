<template>
  <div>
    <h1>发布: 2023年第5期英语周报</h1>
    <button @click="publishEnglish">发布英语周报</button>
  </div>
</template>

<script>
  import pubsub from 'pubsub-js';
  export default {
    name : 'BComponent',
    methods : {
      publishEnglish() {
        // 发布消息
        pubsub.publish('2023年第5期英语周报', '这是第五期英语内容');
      }
    }
  }
</script>
