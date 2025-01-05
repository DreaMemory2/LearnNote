<template>
  <div>
    <h1>{{msg}}</h1>
    <ul>
      <li>名字：{{name}}</li>
      <li>年龄：{{age}}</li>
    </ul>
    <button v-on:click="getInfo">获取用户信息</button>
  </div>
</template>

<script>
  import {MethodMixin} from '../mixin.js';
  import {MountsMixin} from '../mixin.js';

  export default {
    name : 'UserComponent',
    data() {
      return {
        msg : '用户信息',
        name : '张三',
        age : 20
      };
    },
    mounted() {
      console.log('User Mounted');
    },
    mixins : [MethodMixin, MountsMixin]
  };
</script>