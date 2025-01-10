<template>
  <div class="color">
    <h2>颜色</h2>
    <ul>
      <li v-for="(color, index) in $route.query" :key="index">
        {{color}}
      </li>
      <li v-for="(color, index) in $route.params" :key="index">
        {{color}}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name : 'ColorComponent',
  mounted() {
    // 所有的路由组件都有一个属性 $router
    /* 通过这个属性可以获取到该"路由组件"关联的"路由对象" */
    console.log(this.$route);
    /* 路由对象中有一个query属性，这个query属性可以接收query方式传递过来的数据 */
    console.log(this.$route.query);
    
    console.log(this.$route.params);
  }
}
</script>