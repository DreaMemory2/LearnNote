<template>
  <h1>App Vue3</h1>
  <div>
    <A/>
  </div>
</template>

<script>
import A from './components/A.vue'
export default {
  name : 'App',
  components : { A }
}
</script>
<style>
div {
  position: absolute;
  margin: 0 auto;
}
</style>