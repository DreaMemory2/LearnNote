<template>
  <tr>
    <td><input type="checkbox" v-on:checked="select"></td>
    <td class="info">Example</td>
    <td><button class="green-button">删除</button></td>
  </tr>
</template>

<script>
  export default {
    name : 'BugItem',
    methods : {
      select() {
        true;
      }
    }
  };
</script>

<style>
  table tbody tr{
    color: green;
  }
  table tbody tr:nth-child(odd) {
    background-color: rgb(227, 255, 227);
  }
  table tbody tr:hover {
    background-color: rgb(190, 255, 190);
  }
  td {
    border: 1px solid lightgreen;
    text-align: center;
    padding: 5px 0;
  }
</style>