<template>
  <div class="vegetable">
    <h2>蔬菜</h2>
    <ul>
      <li><router-link to="/vegetable/color" active-class="selected">紫薯</router-link></li>
      <li><router-link to="/vegetable/part" active-class="selected">茄子</router-link></li>
      <li>黄瓜</li>
      <li>土豆</li>
    </ul>
    <!-- 子组件 -->
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name : 'VegetableComponent'
}
</script>