<template>
  <div>
    <h1>用户列表</h1>
    <input type="text" v-model="userInfo" />
    <button @click="saveUserInfo(userInfo)">保存用户</button>
    <ul>
      <li v-for="user in users" :key="user.id">
        用户名: {{user.name}}
      </li>
    </ul>
    <h3>当前用户数量: {{users.length}}</h3>
    <h3>当前会员数量: {{vips.length}}</h3>
    <p>反转用户名：{{reverseName}}</p>
  </div>
</template>

<script>
import {mapState, mapGetters, mapActions} from 'vuex';
export default {
  name : 'UserComponent',
  data() {
    return {
      userInfo : ''
    };
  },
  methods : {
    saveUserInfo() {
      /* this.$store.dispatch('saveUserInfo', this.userInfo); */
    },
    /* 既有对象形式，也有数组形式 */
    ...mapActions(['saveUserInfo'])
  },
  computed : {
    ...mapState(['users', 'vips']),
    ...mapGetters(['reverseName'])
  }
};
</script>