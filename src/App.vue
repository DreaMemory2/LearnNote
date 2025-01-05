<template>
  <div class="container">
    <BugHeader></BugHeader>
    <BugList></BugList>
    <BugFooter></BugFooter>
  </div>
</template>

<script>
  import BugHeader from './components/BugHeader.vue';
  import BugList from './components/BugList.vue';
  import BugFooter from './components/BugFooter.vue';

  export default {
    name: 'Application',
    components : {
      BugHeader,
      BugList,
      BugFooter
    }
  };
</script>

<style>
  * {
    padding: 0;
    margin: 0;
  }
  .container {
    position: absolute;
    font-size: 15px;
    border: 2px solid lightgreen;
    margin: 15px;
    padding: 15px;
    box-shadow: 2px 2px 5px 4px rgba(0, 128, 0, 0.3);
  }
</style>