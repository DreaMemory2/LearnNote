<template>
  <div class="fruit">
    <h2>水果</h2>
    <ul>
      <!-- 声明式的路由导航 -->
      <li><router-link to="/fruit/part1" active-class="seleced">苹果</router-link></li>
      <li><router-link to="/fruit/part2?roots=根部&leaves=叶子&fruit=果实" active-class="seleced">香蕉</router-link></li>
      <li><router-link to="" :replace="true" active-class="seleced">雪梨</router-link></li>
      <li><router-link to="" replace active-class="seleced">橘子</router-link></li>
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