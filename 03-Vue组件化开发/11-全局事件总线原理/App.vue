<template>
  <div>
    <!-- 
      1. 关于内置事件的实现步骤
        - 第一步：提供事件源（以下按钮就是一个事件源）
        - 第二步：给事件源绑定事件
          v-on:事件名 或者 @事件名
        - 第三步：编写回调函数，将回调函数和事件进行绑定
        - 第四步：等待事件触发，只要事件触发，则执行回调函数
      2. 关于组件的自定义事件
        - 第一步：提供事件源（是一个组件或者组件对象）
        - 第二步：给组件绑定事件
        - 第三步：编写回调函数，将回调函数和事件进行绑定
        - 第四步：等待事件触发，只要事件触发，则执行回调函数
          想要触发这个事件，首先执行一段代码
          事件绑定在A组件上，则触发这个事件的代码要在A组件当中编写
      3. 总结：到目前为止，父子组件之间如何通信
        父 ->- 子
          props
        子 ->- 父
          第一种方式，在父中定义一个方法，将方法传递给子，然后在子中调用父类过来的方法，这样给父传数据
          第二种方式：使用组件的自定义事件的方式，也可以完成子向父传数据
            在父组件当中绑定事件，在子类当中触发事件
     -->
    <button @click="HelloWorld">实现步骤</button>
    <!-- 给Car绑定一个自定义事件 -->
    <CarComponent v-on:driver="driverCar"></CarComponent>
    <!-- 准备一个组件：打上标记 -->
    <CarComponent ref="car"></CarComponent>
    <h1>事件全局总线</h1>
    <!-- 孙组件 -->
    <VipComponent></VipComponent>
    <!-- 子组件 -->
    <UserComponent></UserComponent>
  </div>
</template>

<script>
  import CarComponent from './components/CarComponent.vue';
  import UserComponent from './components/UserComponent.vue';
  import VipComponent from './components/VipComponent.vue';

  export default {
    name: 'ApplicationComponent',
    components : {
      CarComponent,
      UserComponent,
      VipComponent
    },
    methods : {
      HelloWorld() {
        alert("Hello World!");
      },
      driverCar(name, age) {
        alert("汽车启动");
        alert("汽车类型: " + name);
        alert("驾驶年龄: " + age);
      },
      getVip(name) {
        alert("会员用户" + name);
      }
    },
    mounted() {
      // 获取组件, 通过标记来获取
      /* 给ref="user"的组件绑定event事件，并且event事件绑定一个回调函数 */
      this.$refs.car.$on('driver', this.driverCar);
      /* 如果回调函数是普通函数，函数体当中的this是User组件实例，不是App实例 */
      /* 如果回调函数是箭头函数：函数体当中的this是App组件实例 */

      /* 事件全局总线 */
      /* 绑定事件 */
      this.globalEvent.$on('vipEvent', this.getVip);
    }
  };
</script>