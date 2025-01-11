<template>
  <div>
    <h3>金矿石</h3>
    <ul>
      <li v-for="(ore, index) in $route.query" :key="index">
        <input type="checkbox"/>
        {{ore}}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name : 'GoldOre'
}
</script>