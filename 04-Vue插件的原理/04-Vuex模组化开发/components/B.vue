<template>
  <div>
    <h1>B组件</h1>
    <button @click="doB1">DoB1 BUTTON</button>
    <button @click="doB2">DoB2 BUTTON</button>
    <h3>State : {{$store.state.BModule.b}}</h3>
    <h3>Getters : {{$store.getters['BModule/B']}}</h3>
  </div>
</template>

<script>
export default {
  name : 'BComponents',
  methods : {
    doB1() {
      this.$store.dispatch('BModule/doB1');
    },
    doB2() {
      this.$store.commit('BModule/doB2');
    }
  }
}
</script>