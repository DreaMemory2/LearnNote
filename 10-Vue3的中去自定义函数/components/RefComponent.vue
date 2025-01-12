<template>
  <input type="text" v-model="name" />
  <p>{{name}}</p>
</template>

<script>
  import { ref, customRef } from 'vue';
  export default {
    name : 'RefComponent',
    setup() {
      /* data */
      // let name = ref('test');

      /* 以下这个代码，自定义Ref */
      function useTimerRef(value) {
        // 自定义Ref，这个函数体当中的代码，要符合Ref规范
        /* 通过调用customRef函数获取一个自定义的Ref对象
           调用customRef函数的时候必须给函数传递一个回调函数：这个回调函数可以叫做factory
           对于这个回调函数中有两个参数：track和trigger
            - track: 追踪
            - trigger: 触发
        */
        const custom = customRef((track, trigger) => {
          let timer = 0;
          // 对于这个factory回调来说，必须返回一个对象，并且对象中要有get
          return {
            get() {
              /* 告诉Vue去追踪这个value变化 */
              track();
              return value;
            },
            set(newValue) {
              clearTimeout(timer);
              timer = setTimeout(() => {
                value = newValue;
                // 触发(通知去调用get方法)
                trigger();
              }, 1000);
            }
          }
        });
        /* 返回自定义的ref对象实例 */
        return custom;
      }

      /* 使用自定义ref同样具备响应式 */
      let name = useTimerRef('test');

      /* 返回对象 */
      return {name};
    }
  }
  </script>