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
  beforeRouteEnter(to, from, next) {
    alert("欢迎光临");
    next();
  },
  beforeRouteLeave(to, from, next) {
    alert("欢迎再来");
    next();
  }
}
</script>