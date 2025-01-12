<template>
  <h1>App Vue3</h1>
  输入文字：<input type="text" v-model="data.name">
  <p>文字反转：{{result}}</p>
</template>

<script>
import {computed, reactive} from 'vue';
export default {
  name : 'App',
  /* Vue3计算属性，computed是一个组合式API */
  setup() {
    /* data */
    let data = reactive({
      name : '',
    });

    /* methods */
    /* computed */
    let result = computed(() => {
      /* 这种写法是一种简写形式，如果你只需要使用计算属性get方法的话 */
      return data.name.split('').reverse().join('');
    });

    return {data, result};
  }
}
</script>