/* 导入vue-router插件 */
import VueRouter from 'vue-router';
/* 导入组件 */
import Vegetable from '../pages/Vegetable';
import Fruit from '../pages/Fruit';
import Color from '../pages/Color';
import Part from '../pages/Part';

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
        // 子路由(子路由对象)
        {
          /* 注意：对于子路由来说，path的不能以"/"开始，这个"/"系统自动添加 */
          path : 'color',
          component : Color
        },
        {
          path : 'color1',
          component : Color
        },
        {
          path : 'color2',
          component : Color
        },
        {
          name : 'first',
          path : 'color3',
          component : Color
        },
        {
          name : 'second',
          path : 'color4',
          component : Color
        },
        {
          path : 'color5/:color1/:color2/:color3',
          component : Color
        }
      ]
    },
    {
      // 只要路径监测到是这个路径，则就切换到这个组件
      path : '/fruit',
      component : Fruit,
      children : [
        {
          name : 'part01',
          path : 'part1',
          component : Part,
          /* 在路由当中进行配置 */
          props : {
            roots : '根部',
            leaves : '叶子',
            fruit : '果实'
          }
        },
        {
          path : 'part2',
          component : Part,
          /* props含有函数时写法, $route将会被过来，代表了当前路由对象 */
          props($route) {
            return {
              roots : $route.query.roots,
              leaves : $route.query.leaves,
              fruit : $route.query.fruit
            }
          }
        }
      ]
    }
  ]
});
/* 导出路由器对象(暴露路由器) */
export default router;