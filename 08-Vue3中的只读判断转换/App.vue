<template>
  <h1>App Vue3</h1>
  <h3>深只读</h3>
  <input type="text" v-model="redWool" />
  <h3>浅只读</h3>
  <input type="text" v-model="whiteTerracotta" />
  <hr>
  <p>{{redRaw}}</p>
  <p>{{whiteMark}}</p>
</template>

<script>
import { isReadonly, reactive, readonly, shallowReadonly, toRef, toRaw, markRaw } from 'vue'
export default {
  name : 'App',
  setup() {
    /* data */
    let colors = reactive({
      red : '红色'
    });
    let terracotta = reactive({
      white : {
        color : '白色陶瓦',
        glazed : '带釉白色陶瓦'
      }
    });

    // 深只读(具有响应式的对象，包括子对象中的对象中属性，它的所有值都是只读的不可修改)
    colors = readonly(colors);
    // 浅只读(具有响应式的对象的第一层属性值是只读的)
    terracotta = shallowReadonly(terracotta);

    /* 响应式数据判断 */
    /* 
      1. isRef: 检查某个值是否为ref
      2. isReactive: 检查一个对象是否由reactive创建代理
      3. isProxy: 检查一个对象是否由reactive()创建代理
      4. isReadonly: 检查传入的值是否为只读对象
    */
    console.log(isReadonly(colors));

    /* toRef和toRefs区别 */
    // toRef语法格式: roRef(对象, '该对象的方法名')
    /* toRef函数执行之后会生成一个全新的对象，ObjectRefImpl(引用对象)
       同理，只要有引用对象，就要value，value属性是响应式的, 有set和get方法
    */

    /* toRaw和markRaw */
    /* 转换为原始&标记为原始数据 */
    /* 将color.red转为原始对象(操作原始对象时，没有响应式处理) */
    let redRaw = toRaw(colors.red);
    console.log(redRaw);
    /* 将terracotta.white标记原始对象 */
    let whiteMark = markRaw(terracotta.white);

    return {
      colors, 
      terracotta,
      redWool: toRef(colors.red, 'redWool'),
      whiteTerracotta: toRef(terracotta.white.color, 'whiteTerracotta'),
      /* 原始对象 */
      redRaw,
      whiteMark
    };
  }
}
</script>