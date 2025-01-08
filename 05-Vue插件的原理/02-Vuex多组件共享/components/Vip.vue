<template>
  <div>
    <h1>会员列表</h1>
    <input type="text" v-model="vipInfo" />
    <button @click="saveVipInfo">保存会员</button>
    <ul>
      <li v-for="vip in $store.state.vips" :key="vip.id">
        会员名: {{vip.name}}
      </li>
    </ul>
    <h3>当前用户数量: {{$store.state.users.length}}</h3>
    <h3>当前会员数量: {{$store.state.vips.length}}</h3>
    <p>反转用户名：{{$store.getters.reverseName}}</p>
  </div>
</template>

<script>
export default {
  name : 'VipComponent',
  data() {
    return {
      vipInfo : ''
    };
  },
  methods : {
    saveVipInfo() {
      // 分发dispatch
      /* this.$store.dispatch('saveVipInfo', {id:Date.now(), name:this.vipInfo}); */
      // 如果action中的逻辑非常简单，可以不需要经过action，直接通过commit直接运行mutation
      this.$store.commit('SAVE_VIP_INFO', {id:Date.now(), name:this.vipInfo});
    }
  }
};
</script>