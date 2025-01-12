<template>
  <h1>App Vue3</h1>
  <p>用户：{{name}}</p>
  <p>年龄：{{age}}</p>
  <button @click="helloworld">Hello World</button>
  <p>{{foodRefImpl}}</p>
  <button @click="setFood">设置食物</button>
  <p>{{userRefImpl.name}}</p>
  <button @click="setUser">设置用户名</button>
  <p>{{userPoxy.name}} + {{userPoxy.age}}</p>
</template>

<script>
  import {reactive, ref} from 'vue';
  export default {
    name : 'App',
    /* 1. setup是一个函数，vue3中新增的配置项
       2. 在setup函数体，当中编写 data、methods、computed、watch、生命周期的钩子
    */
    setup() {
      // 数据，在setup函数体当中定义的这个变能量，可以看做之前的data
      /* 通过测试，如果当前的data这样写，没有响应式 */
      let name = 'user';
      let age = 20;
      /* ref对数据进行包裹，并返回一个全新的对象：引用对象RefImpl
         其中，RefImpl对象中有value属性，这个value属性是具有响应式的
         value底层使用Oject.defineProperty完成了响应式
      */
      let foodRefImpl = ref('雪梨');
      /*
        如果是一个对象，响应式使用Proxy实现的 
      */
      let userRefImpl = ref({
        name : "user",
        age : '20'
      });

      /* Reactive函数 */
      /* reactive函数，可以将一个对象直接包裹，实现响应式。底层是生成一个Proxy对象 */
      let userPoxy = reactive({
        name : 'root',
        age : 30
      });

      /* methods方法 */
      function helloworld() {
        console.log(name, age);
        alert('Hello World');
      };
      function setFood() {
        foodRefImpl.value = '苹果';
        console.log(foodRefImpl.value);
      };
      function setUser() {
        /* 新的对象 */
        userRefImpl.value.name = 'admin';
        userRefImpl.value.age = 30;
        console.log(userRefImpl.value.name);
      };

      /* 如果想要模板当中使用属性值，将属性值封装一个对象，然后作为setup函数的返回值即可 */
      return {
        name, age, helloworld, setFood, foodRefImpl, userRefImpl, setUser, userPoxy
      };
    }
  };
</script>
