<template>
  <h1>App Vue3</h1>
  <p>计数器：{{counter}}</p>
  <button @click="counter++">自加一</button>
  <p>{{ores.iron.deeptslateIron}}和{{ores.iron.shallowIron}}</p>
</template>

<script>
import { shallowRef } from 'vue';
export default {
  name : 'App',
  setup() {
    /* data */
    // shallowRef和Ref用在基本数据类型上，没有区别
    let counter = shallowRef(1);
    /* 当shallowRef和Ref都用在对象上的时候
       ref是有响应式的，底层会创建Proxy代理对象
       shallowRef是无响应式，底层不会创建Proxy代理对象
    */
    let ores = shallowRef({
      iron : {
        deeptslateIron : '深层铁矿石',
        shallowIron : '地表铁矿石'
      }
    });

    /* ShallowRecative：只给基本数据类型添加响应式，如果是对象，则不会支持响应式 */

    return {counter, ores};
  }
}
</script>

<style>

</style>