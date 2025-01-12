<template>
  <p>名字：{{name}}</p>
  <p>年龄：{{age}}</p>
  <p>性别：{{sex}}</p>
</template>

<script>
  export default {
    name : 'User',
    props : ['name', 'age', 'sex'],
    setup(props) {
      /* 将来Vue3调用setup函数之前，会给第一个参数传递: props */
      /* props被包装成代理对象，也是具有响应式的Proxy对象 */
      console.log(props);
    }
  }
</script>