<template>
  <div>
    <h1>{{msg}}</h1>
    <ul>
      <li>名字：{{name}}</li>
      <li>年龄：{{age}}</li>
      <li>会员：{{vip}}</li>
    </ul>
    <button v-on:click="getInfo">获取会员信息</button>
    <button v-on:click="getVip">获取会员等级</button>
  </div>
</template>

<script>
  import {MethodMixin} from '../mixin.js';
  import {getVipMixin} from '../mixin.js';

  export default {
    name : 'VipComponent',
    data() {
      return {
        msg: '会员信息',
        name : '张三',
        age : 20,
        vip : '2v'
      };
    },
    methods : {
      getVip() {
        console.log('Vip 2v');
      }
    },
    mixins : [MethodMixin, getVipMixin]
  };
</script>