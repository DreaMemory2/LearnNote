import FoodComponent from './FoodComponent.vue';

new Vue({
  name : 'Application',
  el : '#root',
  data : {
    msg : '组件嵌套'
  },
  // 使用组件
  components : {FoodComponent}
});