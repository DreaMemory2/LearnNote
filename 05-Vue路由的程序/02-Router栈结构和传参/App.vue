<template>
  <div>
    <div>
      <h1>食物</h1>
      <ul>
        <!-- 如果使用的路由方式，就不能使用a标签，需要使用vue-router提供的标签 -->
        <!-- router-link 将来会被自动编译为a标签  -->
        <li><router-link to="/vegetable" active-class="selected">蔬菜</router-link></li>
        <li><router-link to="/Fruit" active-class="selected">水果</router-link></li>
      </ul>
    </div>
    <!-- 这个位置将来是要显示对应的组件的 -->
    <!-- 路由视图，其实就是起到占位的作用 -->
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name : 'AppComponent',
}
</script>

<style>
div.vegetable, div.fruit {
  margin-left: 70px;
}
div.color, div.part {
  margin-left: 70px;
}
.selected {
  background-color: aqua;
}

</style>