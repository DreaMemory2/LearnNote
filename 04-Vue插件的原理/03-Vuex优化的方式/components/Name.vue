<template>
  <div>
    <input type="text" v-model="$store.state.username" />
    <p>反转用户名：{{reverseName}}</p>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';
export default {
  name : 'NameComponent',
  computed : {
    /* 代码生成的以下代码是简写形式的计算属性，只有get方法, 没有set方法 */
    ...mapGetters(['reverseName'])
  }
};
</script>