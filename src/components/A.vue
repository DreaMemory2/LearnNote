<template>
  <div>
    <h1>A组件</h1>
    <button @click="doA1">DoA1 BUTTON</button>
    <button @click="doA2">DoA2 BUTTON</button>
    <h3>State : {{$store.state.AModule.a}}</h3>
    <h3>Getters : {{$store.getters['AModule/A']}}</h3>
  </div>
</template>

<script>
export default {
  name : 'AComponents',
  methods : {
    doA1() {
      this.$store.dispatch('AModule/doA1');
    },
    doA2() {
      this.$store.commit('AModule/doA2');
    }
  }
}
</script>