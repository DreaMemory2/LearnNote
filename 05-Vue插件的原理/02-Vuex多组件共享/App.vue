<template>
  <div>
    <User />
    <hr>
    <Vip />
    <hr>
    <Name />
  </div>
</template>

<script>
import User from './components/User';
import Vip from './components/Vip';
import Name from './components/Name';
export default {
  name : "AppComponent",
  components : {
    User,
    Vip,
    Name
  }
};
</script>