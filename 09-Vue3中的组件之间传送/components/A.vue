<template>
  <div class="a">
    <B/>
  </div>
</template>

<script>
import B from './B.vue';
export default {
  name : 'AComponent',
  components : { B }
}
</script>

<style scoped>
.a {
  position: relative;
  height: 300px;
  width: 300px;
  background: lightgreen;
}
</style>