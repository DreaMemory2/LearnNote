<template>
  <div>
    <h3>汽车品牌</h3>
    <ul>
      <li>品牌：{{brand}}</li>
      <li>价格：{{number}}</li>
      <li>颜色：{{color}}</li>
    </ul>
    <button v-on:click="add" >价格自加一</button>
  </div>
</template>

<script>
export default {
  name: 'CarComponent',
  data() {
    return {
      number : this.price
    };
  }, 
  methods : {
    add() {
      // 避免直接更改prop，因为每当父组件重新渲染时，该值都会被覆盖
      // 注意：不要修改prop中的数据
      this.number++;
    }
  },
  // 在Car这个子组件当中使用props配置项进行数据的接收
  // 第一种：简单方式的接收方式，直接采用数组接收
  props : ['brand', 'price', 'color'],
  // 第二种：添加类型限制
  props : {
    brand : String,
    price : Number,
    color : String
  },
  // 第三种：添加类型限制，并且还可以添加默认值，还可以添加必要性
  props : {
    brand : {
      type : String,
      required : true
    },
    price : {
      type : Number,
      default : 10
    },
    color : {
      type : String,
      default : '黑色'
    }
  }
};
</script>