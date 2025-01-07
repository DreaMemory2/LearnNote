<template>
  <div>
    <h1 ref="info">{{msg}}</h1>
    <!-- 使用组件 -->
    <!-- 在App这个组件当中，找到子组件CarComponent，然后CarComponent这个子组件传入数据，通过属性形式传数据 -->
    <CarComponent brand="宝马520" v-bind:price="10" color="黑色" ref="car01"></CarComponent>
    <CarComponent brand="比亚迪汉" v-bind:price="20" color="白色"></CarComponent>
    <hr>
    <h1>在父组件中获取子组件</h1>
    <button v-on:click="getInfo">获取汽车品牌信息</button>
  </div>
</template>

<script>
import CarComponent from './components/CarComponent.vue'

export default {
  name : 'Application',
  data() {
    return {
      msg : '汽车信息-Props配置'
    };
  },
  methods : {
    getInfo() {
      /* 
      第一步：在子组件打标记
      第二步：获取子组件 
      */
      console.log(this.$refs.car01);
      // 获取汽车信息
      console.log(this.$refs.car01.brand, this.$refs.car01.price, this.$refs.car01.color);
      // 获取DOM元素
      console.log(this.$refs['info']);
    }
  },
  /* 注册组件 */
  components : {
    CarComponent
  }
}
</script>
