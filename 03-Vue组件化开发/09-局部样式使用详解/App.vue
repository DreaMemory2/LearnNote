<template>
  <div>
    <h1>局部样式</h1>
    <ToolComponent></ToolComponent>
  </div>
</template>

<script>
import ToolComponent from './components/ToolComponent.vue'

export default {
  name : 'Application',
  components : {
    ToolComponent
  }
}
</script>

<style>
  /* 一般在App根组件当中样式不会添加scoped，因为跟组件的样式，希望采用局部方式来处理 */
</style>