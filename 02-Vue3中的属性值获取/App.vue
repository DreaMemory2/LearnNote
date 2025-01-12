<template>
  <h1>App Vue3</h1>
  <User name="张三" age="20" :sex="sex" />
</template>

<script>
  import { ref } from 'vue';
  import User from './components/User.vue'
  export default {
    name : 'AppComponent',
    components : {User},
    setup() {
      /* data */
      let sex = ref('男');

      return {sex};
    }
  }
</script>