<template>
  <div>
    <button @click="triggerVipEvent">获取会员</button>
  </div>
</template>

<script>
  export default {
    name : 'VipComponent',
    data() {
      return {
        name : 'VipUser'
      }
    },
    methods : {
      triggerVipEvent() {
        // 获取共享vc对象
        this.globalEvent.$emit('vipEvent', this.name);
      }
    }
  }
</script>