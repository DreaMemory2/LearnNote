// 每一个插件都是一个对象
export const plugin = {
  // 每一个插件对象必须有一个install方法
  // 这个install方法会被自动调用
  /* 
    第一部分：Vue构造函数 
    第二部分：可以接收用户在使用这个插件时传过来的数据集，参数无限制
  */
  install(Vue, parameter) {
    console.log('使用插件');
  }
};

// 暴露插件