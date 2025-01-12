<template>
  <div class="b">
    <C/>
  </div>
</template>

<script>
import C from './C.vue';
export default {
  name : 'BComponent',
  components : { C }
}
</script>

<style scoped>
.b {
  position: relative;
  top: 50px;
  height: 200px;
  width: 200px;
  background: lightpink;
}
</style>