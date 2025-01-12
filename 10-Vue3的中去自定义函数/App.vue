<template>
  <h1>App Vue3</h1>
  <input type="text" v-model="name"/>
  <br>
  {{newName}}
  <h1>自定义Ref</h1>
  <Ref></Ref>
</template>

<script>
  import Ref from './components/RefComponent.vue'
  import { ref, watch } from 'vue';
  export default {
    name : 'App',
    components : {
      Ref
    },
    setup() {
      /* data */
      let name = ref('');
      let newName = ref(name.value);
      /* methods */
      // 监听属性
      watch(name, (newValue) => {
        setTimeout(() => {
          newName.value = newValue;
        }, 500);
      });

      /* 返回一个对象 */
      return {name, newName};
    }
  }
</script>

<style>
input {
  display: block;
}
</style>