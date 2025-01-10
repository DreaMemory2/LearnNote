<template>
  <div>
    <h1>矿石展览</h1>
    <!-- 声明式路由导航，只适合超链接 -->
    <!-- <router-link to="/ore/iron">铁矿石</router-link><br> -->
    <button @click="getIronOre">铁矿石</button><br>
    <button @click="getGoldOre">金矿石</button>

    <!-- 展示组件 -->
    <!-- 这个标签，如果这样编写，表示标签中所有的路由组件在切换的时候不会销毁 -->
    <!-- 注意：表示在进行路由组件切换的时候，该组件不被销毁，保留状态 -->
    <keep-alive include="IronOre">
      <router-view></router-view>
    </keep-alive>
  </div>
</template>

<script>
export default {
  name : 'OreComponent',
  data() {
    return {
      irons : ['褐铁矿', '磁铁矿', '赤铁矿', '菱铁矿'],
      golds : ['岩金矿', '铂金矿', '铜金矿', '金银矿']
    }
  },
  methods : {
    getIronOre() {
      /* 
        1. 这里编写代码，完成路由组件的切换
        2. 这种通过编程的方式完成路由组件的切换，被称为：编程式路由导航
        3. 通过调用现有的API就可以完成路由组件的切换
        4. 先获取路由器对象，this.$router
        5. 注意: 在使用编程式的路由导航时，push以及replace方法会返回一个Promise对象
          Promise对象期望你能通过参数的方式给它两个回调函数，一个成功的回调，一个是失败的回调
          如果没有提供这个两个回调函数，则会出现错误，解决：在参数位置上提供两个回调函数
      */
      this.$router.push({
        name : 'iron',
        query : {
          ore1 : this.irons[0],
          ore2 : this.irons[1],
          ore3 : this.irons[2],
          ore4 : this.irons[3]
        }
      }, () => {}, () => {});
    },
    getGoldOre() {
      this.$router.push({
        name : 'gold',
        query : {
          ore1 : this.golds[0],
          ore2 : this.golds[1],
          ore3 : this.golds[2],
          ore4 : this.golds[3]
        }
      }, () => {}, () => {});
    }
  }
}
</script>

<style>

</style>