<template>
  <div>
    <h1>App组件</h1>
    <!-- 使用组件 -->
    <FoodComponent></FoodComponent>
  </div>
</template>

<script>
import FoodComponent from './components/FoodComponent.vue';

export default {
  /* 注册组件 */
  components : {
    FoodComponent
  }
}
</script>
