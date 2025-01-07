<template>
  <div>
    <!-- 使用组件 -->
    1. {{foods[0].name}}<vegetable-list></vegetable-list>
    2. {{foods[1].name}}<fruit-list></fruit-list>
  </div>
</template>

<script>
import VegetableComponent from './VegetableComponent.vue';
import FruitComponent from './FruitComponent.vue';
export default {
  data() {
    return {
      foods : [
        {id: '1', name: '蔬菜'},
        {id: '2', name: '水果'},
        {id: '3', name: '谷物'},
        {id: '4', name: '肉类'}
      ]
    };
  },
  /* 注册子组件 */
  components : {
    'vegetable-list' : VegetableComponent,
    'fruit-list' : FruitComponent
  }
};
</script>