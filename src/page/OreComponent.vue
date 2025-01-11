<template>
  <div>
    <h1>矿石展览</h1>
    <button @click="getIronOre">铁矿石</button><br>
    <button @click="getGoldOre">金矿石</button>
    <router-view></router-view>
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