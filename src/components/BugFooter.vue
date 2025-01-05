<template>
  <footer>
    <button class="green-button">已解决</button>
    <span>&emsp;当前BUG总量为2个, 已解决1个</span>
  </footer>
</template>

<script>
  export default {
    name : 'BugFooter'
  };
</script>

<style>
  footer {
    margin-top: 10px;
  }
  span {
    color: lightgreen;
  }
</style>