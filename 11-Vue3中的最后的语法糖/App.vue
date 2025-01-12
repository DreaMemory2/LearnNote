<template>
  <h1>App Vue3</h1>
  <h3>计数器：{{counter}}</h3>
  <button @click="add">自加一</button>
  <hr>
  <A></A>
</template>

<script setup>
  import { ref } from "vue";
  import A from './components/A.vue';
  let counter = ref(0);
  function add() {
    counter.value++;
  }
</script>