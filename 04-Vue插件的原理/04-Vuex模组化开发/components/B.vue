<template>
  <div>
    <h1>B组件</h1>
    <button @click="doB1">DoB1 BUTTON</button>
    <button @click="doB2">DoB2 BUTTON</button>
    <h3>State : {{b}}</h3>
    <h3>Getters : {{B}}</h3>
  </div>
</template>

<script>
import {mapState, mapGetters, mapActions, mapMutations} from 'vuex';
export default {
  name : 'BComponents',
  computed : {
    ...mapState('BModule', ['b']),
    ...mapGetters('BModule', ['B'])
  },
  methods : {
    ...mapActions('BModule', ['doB1']),
    ...mapMutations('BModule', ['doB2'])
  }
}
</script>