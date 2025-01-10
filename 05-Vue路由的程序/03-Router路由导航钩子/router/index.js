import Router from 'vue-router';
/* 导入组件 */
import OreComponent from '../page/OreComponent';
import IronOre from '../page/IronOre'
import GoldOre from '../page/GoldOre'

export default new Router({
  routes : [
    {
      path : '/ore',
      component : OreComponent,
      children : [
        {
          name : 'iron',
          path : 'iron',
          component : IronOre
        },
        {
          name : 'gold',
          path : 'gold',
          component : GoldOre
        }
      ]
    }
  ]
});