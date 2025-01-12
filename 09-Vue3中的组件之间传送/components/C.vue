<template>
  <div class="c">
    <button class="show" @click="isShow = true">弹窗</button>
    <teleport to="body">
      <!-- 遮罩层 -->
      <div v-show="isShow" class="cover">
        <!-- 模态窗口 -->
        <div class="show">
          我是一个窗口...
          <button @click="isShow = false" class="close">关闭</button>
        </div>
      </div>
    </teleport>
  </div>
</template>

<script>
import { ref } from 'vue'
export default {
  name : 'CComponent',
  setup() {
    /* data */
    let isShow = ref(false);

    /* 返回一个对象 */
    return {isShow}
  }
}
</script>

<style scoped>
.c {
  position: relative;
  top: 50px;
  height: 100px;
  width: 100px;
  background: lightsalmon;
}

button.show {
  background: lightsalmon;
}
button.close {
  background: lightblue;
}

button.show, button.close {
  color : white;
  font-size: 25px;
  position: relative;
  top: 32px;
  text-align: center;
  display: block;
  margin: 0 auto;
  border: none;
}
div.show {
  position: absolute;
  height: 200px;
  width: 200px;
  top: 50%;
  left: 50%;
  margin-top: -50px;
  margin-left: -50px;
  background: lightblue;
}

.cover {
  position: absolute;
  margin: 0 auto;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  opacity: 0.90;
  background: lightslategray;
}
</style>