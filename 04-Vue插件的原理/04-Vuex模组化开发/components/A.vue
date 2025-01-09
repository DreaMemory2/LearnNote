<template>
  <div>
    <h1>A组件</h1>
    <button @click="doA1">DoA1 BUTTON</button>
    <button @click="doA2">DoA2 BUTTON</button>
    <h3>State : {{a}}</h3>
    <h3>Getters : {{A}}</h3>
  </div>
</template>

<script>
import {mapState, mapGetters, mapActions, mapMutations} from 'vuex';
export default {
  name : 'AComponents',
  computed : {
    ...mapState('AModule', ['a']),
    ...mapGetters('AModule', ['A'])
  },
  methods : {
    ...mapActions('AModule', ['doA1']),
    ...mapMutations('AModule', ['doA2'])
  }
}
</script>