<template>
  <div>
    <h1>App组件</h1>
    <p>数字：{{$store.state.number}}</p>
    <button @click="addNumber">自加一</button>
    <!-- 其他组件同步更新 -->
    <AComponent></AComponent>
  </div>
</template>

<script>
  import AComponent from './components/AComponent.vue';
  export default {
    name : 'AppComponent',
    data() {
      return {
        number : 0
      };
    },
    methods : {
      addNumber() {
        /* 代码无法得到复用 */
        /* ++this.$store.state.number; */
        /* - 调用vuex的API, dispatch是vuex的API, 
          调用这个方法之后，store对象中的addNumber这个action回调函数会被自动调用
        */
        this.$store.dispatch('addNumber', this.number);
      }
    },
    components : {
      AComponent
    }
  }
</script>
