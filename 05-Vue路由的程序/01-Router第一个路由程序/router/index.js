/* 导入vue-router插件 */
import VueRouter from 'vue-router';
/* 导入组件 */
import Vegetable from '../pages/Vegetable';
import Fruit from '../components/Fruit';
import Color from '../components/Color.vue';
import Part from '../components/Part';

/* 创建路由器对象(配置路由器) */
const router = new VueRouter({
  // 在这里配置所有的路由规则
  routes : [
    {
      /* 这个可以看做就是路由的key */
      path : '/vegetable',
      /* 这个可以看做就是路由的value */
      component : Vegetable,
      children : [
        // 子路由s
        {
          /* 注意：对于子路由来说，path的不能以"/"开始，这个"/"系统自动添加 */
          path : 'color',
          component : Color
        },
        {
          path : 'part',
          component : Part
        }
      ]
    },
    {
      // 只要路径监测到是这个路径，则就切换到这个组件
      path : '/fruit',
      component : Fruit
    }
  ]
});
/* 导出路由器对象(暴露路由器) */
export default router;