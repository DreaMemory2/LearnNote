<template>
  <h2>计时器: {{counter}}</h2>
  <button @click="counter++">自加一</button>
  <h2>{{wools.wool}}</h2>
  <input type="text" v-model="wools.wool">
</template>

<script>
import { reactive, ref, watch, watchEffect } from 'vue'
export default {
  name : 'App',
  /* 组合式API: watch(监听) */
  setup() {
    /* data */
    // 监听ref数据
    let counter = ref(0);
    // 监听reactive数据
    let wools = reactive({
      wool : '白色羊毛'
    });
    let ores = reactive({
      iron : '铁矿',
      gold : '金矿',
      cupper : '铜矿'
    });
    /* methods */
    /* watch: 被监视的数据具有响应式 */
    watch(counter, (newValue, oldValue) => {
      console.log(newValue, oldValue);
    }, {immediate : true, deep : true});
    /* 对于reactive函数获取的代理对象，只能获取到newValue，oldValue无法获取
       对于reactive函数获取的代理对象，默认就是开启深度侦听的，但是无法取消的
    */
    watch(wools, (newValue) => {
      console.log(newValue);
    });
    /* 如果侦听某个属性的数据，必须是一个函数 */
    /* watch(() => data.counter, (newValue) => {...}) */

    /* 使用WatchEffect这个组合式API，用来监视的
       注意：这个函数中直接跟一个回调函数，监视到某个数据发生变化就执行
       回调函数一开始先执行一次，然后函数体当中使用到了某个数据
       这个使用到的数据只要发生变化，watchEffect中的回调函数一定会执行一次
    */
    watchEffect(()=>{
      /* 这个回调函数当中使用到了iron和gold
         这个回调函数的执行实际是：只要iron发生变化，或者gold发生变化，这个回调函数都会发生变化
      */
      const a = ores.iron;
      const b = ores.gold;
      console.log(a, b);
    });

    /* 返回对象 */
    return {counter, wools};
  }
}
</script>