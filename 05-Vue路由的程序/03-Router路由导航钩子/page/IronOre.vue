<template>
  <div>
    <h3>铁矿石</h3>
    <ul>
      <li v-for="(iron, index) in this.$route.query" :key="index">
        <input type="checkbox"/>
        {{iron}}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name : 'IronOre',
  beforeDestroy() {
    console.log('路由组件已销毁');
  },
  /* 路由组件的钩子 */
  activated() {
    console.log('激活了');
    // 挂载完毕之后，创建一个定时器，每个一秒打印一句话
    this.timer = setInterval(() => {
      console.log('一个定时器')
    }, 1000);
  },
  deactivated() {
    console.log('失效了');
    // 清除定时器
    clearInterval(this.timer);
  },
  beforeDestroy() {
    // 删除定时器
    clearInterval(this.timer);
  }
}
</script>