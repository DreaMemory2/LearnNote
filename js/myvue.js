// 定义一个Vue类
class MyVue {
  // 定义构造函数
  /* options是一个简单的纯粹的JS对象 */
  constructor(options){
    this;

    /* 获取所有的属性名 */
    Object.keys(options.data).forEach((propertyName) => {
      // 首字母不是_，并且也不是$
      let charactor = propertyName.charAt(0);
      if (charactor != '_' && charactor != '$') {
        Object.defineProperty(this, propertyName, {
          // 数据代理
          get(){
            return options.data[propertyName]
          },
          // 数据劫持
          set(value){
            // 1. 修改内存中对象的属性值
            options.data[propertyName] = value;
            // 2. 重新渲染页面
          }
        });
      };
    });

    /* 获取所有的方法名 */
    Object.keys(options.methods).forEach((methodName) => {
      // 给当前的Vue实例扩展一个方法
      this[methodName] = options.methods[methodName];
    });
  };
}