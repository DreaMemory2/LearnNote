<template>
  <div>
    <h1>用户列表</h1>
    <input type="text" v-model="userInfo" />
    <button @click="saveUserInfo">保存用户</button>
    <ul>
      <li v-for="user in $store.state.users" :key="user.id">
        用户名: {{user.name}}
      </li>
    </ul>
    <h3>当前用户数量: {{$store.state.users.length}}</h3>
    <h3>当前会员数量: {{$store.state.vips.length}}</h3>
    <p>反转用户名：{{$store.getters.reverseName}}</p>
  </div>
</template>

<script>
export default {
  name : 'UserComponent',
  data() {
    return {
      userInfo : ''
    };
  },
  methods : {
    saveUserInfo() {
      /* this.$store.dispatch('saveUserInfo', {id:Date.now(), name:this.userInfo}); */
      this.$store.commit('SAVE_USER_INFO', {id:Date.now(), name:this.userInfo});
    }
  }
};
</script>