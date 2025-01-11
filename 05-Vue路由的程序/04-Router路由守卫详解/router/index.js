import Router from 'vue-router';
/* 导入组件 */
import OreComponent from '../page/OreComponent';
import IronOre from '../page/IronOre'
import GoldOre from '../page/GoldOre'

const router = new Router({
  routes : [
    {
      name : 'ore',
      path : '/ore',
      component : OreComponent,
      children : [
        {
          name : 'iron',
          path : 'iron',
          component : IronOre,
          /* 添加自定义属性 */
          meta : {
            /* 带有这个属性，并且值为true，则该路由组件需要鉴权 */
            isAuth : true,
            title : '铁矿石'
          }
        },
        {
          /* 1. 这个局部守卫之path守卫，写到router对象中
             2. beforeEnter本身就是一个函数，参数没有回调函数
             3. 有三个参数：to from next
             4. beforeEnter进入"gold"这个路由前调用
            */
          beforeEnter(to, from, next) {
            let loginName = '张三';
            if (loginName === '张三') {
              next();
            } else {
              alert('对不起，您没有权限！');
            };
          },
          name : 'gold',
          path : 'gold',
          component : GoldOre,
          meta : { 
            isAuth : false,
            title : '金矿石'
          }
        }
      ]
    }
  ]
});

/* 全局前置守卫 */
/* 1.代码写在创建router之后，以及暴露router之前
   2.beforeEach中的callback，在初始化的时候执行一次，以后每一次切换任意路由组件之前都会被调用
    - router.beforeEach(callback);
   3. callback函数有三个参数：to from next
    - from 参数：是一个路由对象，表示从A路由组件切换到B路由组件，起点
    - to 参数：是一个路由对象，表示从A路由组件到达B路由组件，终点
    - next 参数：这是一个函数，调用函数之后，表示放行，可以继续向下走
   4. 给路由对象添加添加自定义属性，需要在路由对象的meta(路由源)中定义
*/
router.beforeEach((to, from, next) => {
  let loginName = 'admin'
  if (to.meta.isAuth) {
    if (loginName === 'admin') {
      // 放行
      next();
    } else {
      alert('对不起，您没有权限！');
    };
  } else {
    next();
  };
});

/* 全局后置守卫 */
/* 1. 代码写在创建router之后，以及暴露router之前
   2. afterEach在初始化的时候执行一次，以后每一次切换完成任意路由组件之前都会被调用
   3. 这个回调函数有to和from参数，没有next参数
*/
router.afterEach((to, from) => {
  document.title = to.meta.title || '欢迎使用';
});

export default router;