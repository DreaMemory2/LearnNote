<template>
  <div class="vegetable">
    <h2>蔬菜</h2>
    <ul>
      <!-- 采用query方式传参，这里使用的是字符串拼接方式 -->
      <li><router-link :to="`/vegetable/color1?${addressInfo}`" active-class="selected">紫薯</router-link></li>
      <li><router-link :to="`/vegetable/color2?${addressInfo}`" active-class="selected">茄子</router-link></li>
      <!-- 采用query方式传参，这里使用的是对象形式 -->
      <li>
        <router-link active-class="selected" :to="{
          // 注意：如果使用name，则要求必须使用对象形式，不能使用字符串形式
          name : 'first',
          query : {
            color1 : colors[0],
            color2 : colors[1],
            color3 : colors[2]
          }
        }">
          黄瓜
        </router-link>
      </li>
      <li>
        <router-link active-class="selected" :to="{
          name : 'second',
          query : {
            color1 : colors[0],
            color2 : colors[1],
            color3 : colors[2]
          }
        }">
          土豆
        </router-link>
      </li>
      <!-- params方式传参：字符串形式 -->
      <li><router-link :to="`/vegetable/color5/${paramsInfo}`">菠菜</router-link></li>
      <!-- params方式传参，对象形式 -->
      <!-- 强调：如果使用的是params方式传参，这里只能使用name，不能使用path -->
    </ul>
    <!-- 子组件 -->
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name : 'VegetableComponent',
  data() {
    return {
      colors : ['红色', '蓝色', '绿色']
    };
  },
  computed : {
    addressInfo() {
      let result = '';
      this.colors.forEach((color, index) => {
        result += "color" + ++index + "=" + color;
        if (index < this.colors.length) result += '&';
      });
      return result;
    },
    paramsInfo() {
      let result = '';
      this.colors.forEach(color => {
        result += color + '/';
      })
      return result;
    }
  }
}
</script>