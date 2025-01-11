import Router from 'vue-router';
import OreComponent from '../page/OreComponent';
import IronOre from '../page/IronOre'
import GoldOre from '../page/GoldOre'

const router = new Router({
  mode : 'hash',
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
          meta : {
            isAuth : true,
            title : '铁矿石'
          }
        },
        {
          beforeEnter(to, from, next) {
            let loginName = '张三';
            if (loginName === '张三') {
              next();
            } else {
              alert('对不起，您没有权限！');
            }
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
router.beforeEach((to, from, next) => {
  let loginName = 'admin'
  if (to.meta.isAuth) {
    if (loginName === 'admin') {
      next();
    } else {
      alert('对不起，您没有权限！');
    }
  } else {
    next();
  }
});
router.afterEach((to) => {
  document.title = to.meta.title || '欢迎使用';
});

export default router;