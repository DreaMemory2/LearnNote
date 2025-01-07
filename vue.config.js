const { defineConfig } = require('@vue/cli-service');
module.exports = defineConfig({
  transpileDependencies: true,
  /* 检查是否进行语法检查，true表示进行语法检查 */
  lintOnSave : true,
  /* page : {
    index: {
      // page 入口
      entry: 'src/main.js'
    }
  } */
});
