<template>
  <div>
    <p>数字：{{$store.state.number}}</p>
  </div>
</template>

<script>
export default {
  name : 'AComponent',
  data() {
    return {
      number : 0
    };
  }
}
</script>

<style>

</style>