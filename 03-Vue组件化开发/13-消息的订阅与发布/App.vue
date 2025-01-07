<template>
  <div>
    <BComponent/>
    <AComponent/>
  </div>
</template>

<script>
  import AComponent from './components/A.vue';
  import BComponent from './components/B.vue';
  export default {
    name : 'ApplicationComponent',
    components : {
      AComponent,
      BComponent
    }
  }
</script>
