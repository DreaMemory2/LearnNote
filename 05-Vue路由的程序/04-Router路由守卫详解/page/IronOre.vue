<template>
  <div>
    <h3>铁矿石</h3>
    <ul>
      <li v-for="(iron, index) in this.$route.query" :key="index">
        <input type="checkbox"/>
        {{iron}}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name : 'IronOre',
  /* 
    1. 局部守卫之component守卫，代码写在component当中
    2. beforeRouteEnter执行时机：进入路由组件之前执行
  */
  beforeRouteEnter(to, from, next) {
    alert("欢迎光临");
    next();
  },
  /* 3. beforeRouteLeave执行时机：离开路由组件之前执行 */
  beforeRouteLeave(to, from, next) {
    alert("欢迎再来");
    next();
  }
}
</script>