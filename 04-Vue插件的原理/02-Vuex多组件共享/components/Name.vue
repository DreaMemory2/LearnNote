<template>
  <div>
    <input type="text" v-model="$store.state.username" />
    <p>反转用户名：{{$store.getters.reverseName}}</p>
  </div>
</template>

<script>
export default {
  name : 'NameComponent'
};
</script>

<style>

</style>