<template>
  <div>
    <UserComponent></UserComponent>
    <VipComponent></VipComponent>
  </div>
</template>

<script>
import UserComponent from './components/UserComponent.vue';
import VipComponent from './components/VipComponenr.vue';

export default {
  name : 'Application',
  components: {
    UserComponent,
    VipComponent
  }
}
</script>