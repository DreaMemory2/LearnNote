<template>
  <tr>
    <td><input type="checkbox" v-bind:checked="resolved" v-on:change="modifyResolved(id)"></td>
    <!-- <td><input type="checkbox" v-model="resolved"></td> -->
    <td class="info">{{content}}</td>
    <td><button class="green-button" v-on:click="deleteById(id)">删除</button></td>
  </tr>
</template>

<script>
  export default {
    name : 'BugItem',
    props : {
      id: {
        type : Number,
        requred : true
      },
      content: {
        type : String
      },
      resolved : {
        type : Boolean,
        requred : true
      },
      modifyResolvedCallback : function() {

      },
      deleteByIdCallback : function() {
        
      }
    },
    methods : {
      modifyResolved(id) {
        this.modifyResolvedCallback(id);
      },
      deleteById(id) {
        this.deleteByIdCallback(id);
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