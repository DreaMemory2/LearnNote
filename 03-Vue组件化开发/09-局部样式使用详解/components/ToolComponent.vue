<template>
  <div class="contain">
    <h1>{{msg}}</h1>
    <p>{{tool}}</p>
    <p>{{damage}}</p>
  </div>
</template>

<script>
  export default {
    name : 'ToolComponent',
    data() {
      return {
        msg : '工具模板',
        tool : '钻石剑',
        damage : 10
      };
    }
  };
</script>

<style scoped>
  .contain {
    background: lightcyan;
    padding: 10px;
    text-align: center;
  }
</style>