<template>
  <div class="fruit">
    <h2>水果</h2>
    <ul>
      <li><router-link to="/fruit/part1">苹果</router-link></li>
      <li><router-link to="/fruit/part2?roots=根部&leaves=叶子&fruit=果实">香蕉</router-link></li>
      <li>雪梨</li>
      <li>橘子</li>
    </ul>

    <!-- 展示插件 -->
    <router-view></router-view>
  </div>  
</template>

<script>
export default {
  name : 'FruitComponent'
}
</script>