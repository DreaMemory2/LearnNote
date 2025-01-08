<template>
  <div>
    <h1>会员列表</h1>
    <input type="text" v-model="vipInfo" />
    <button @click="saveVipInfo(vipInfo)">保存会员</button>
    <ul>
      <li v-for="vip in vips" :key="vip.id">
        会员名: {{vip.name}}
      </li>
    </ul>
    <h3>当前用户数量: {{users.length}}</h3>
    <h3>当前会员数量: {{vips.length}}</h3>
    <p>反转用户名：{{reverseName}}</p>
  </div>
</template>

<script>
/* vuex插件提供的内置的mapState对象, 负责state对象工作的一个对象 */
import {mapState, mapGetters, mapMutations} from 'vuex';
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
      /* this.$store.commit('SAVE_VIP_INFO', this.vipInfo); */
    },
    /* 既有对象形式，也有数组形式 */
    ...mapMutations({saveVipInfo : 'SAVE_VIP_INFO'})
  },
  computed : {
    // 可以借助mapState生成代码
    /* 对象形式 */
    /* ...mapState({users: 'users', vips : 'vips'}) */
    /* 数组形式(这种方式表示计算属性的名字和state中的属性名一致) */
    ...mapState(['users', 'vips']),
    ...mapGetters(['reverseName'])
  },
  mounted() {
    const x = mapState({users: 'users', vips : 'vips'});
    console.log(x);
  }
};
</script>