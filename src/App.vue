<template>
  <div>
    <h1>路由导航</h1>
    <router-link to="/ore">矿石</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name : 'AppComponent'
}
</script>