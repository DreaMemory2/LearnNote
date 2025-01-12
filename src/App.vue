<template>
  <p>用户：{{name}}</p>
  <p>年龄：{{age}}</p>
</template>

<script>
  export default {
    name : 'App',
    /* 1. setup是一个函数，vue3中新增的配置项
       2. 在setup函数体，当中编写 data、methods、computed、watch、生命周期的钩子
       3. 
    */
    setup() {
      // 数据，在setup函数体当中定义的这个变能量，可以看做之前的data
      let name = 'user';
      let age = 20;
      /* 如果想要模板当中使用属性值，将属性值封装一个对象，然后作为setup函数的返回值即可 */
      return {
        name, age
      }
    }
  };
</script>
