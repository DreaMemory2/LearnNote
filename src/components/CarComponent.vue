<template>
  <div>
    <button @click="driverCar">触发事件</button>
    <button @click="moreMethods">新的语法</button>
  </div>
</template>

<script>
  export default {
    name : 'CarComponent',
    data() {
      return {
        name : '汽车',
        age : '3年'
      }
    },
    methods : {
      driverCar() {
        // 编写触发driver事件的代码
        /* this是当前的组件实例：vc */
        this.$emit('driver', this.name, this.age);
      },
      // ES6的语法 ...params, 可以看作一个数组
      moreMethods(name, ...params) {
        console.log(name, params);
      }
    }
  }
</script>

<style>

</style>