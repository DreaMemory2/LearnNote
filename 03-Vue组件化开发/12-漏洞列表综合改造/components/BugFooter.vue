<template>
  <footer v-show="lists.length">
    <button class="green-button" v-on:click="clearResolved">清除已解决</button>
    <span>&emsp;当前BUG总量为{{lists.length}}个, 已解决{{resolved}}个</span>
  </footer>
</template>

<script>
  export default {
    name : 'BugFooter',
    props : ["lists"],
    methods : {
      clearResolved() {
        this.$emit('clearResolvedCallback');
      }
    },
    computed : {
      resolved() {
        // 采用普通计数器方式
        let count = 0;
        this.lists.forEach((bug) => {
          if (bug.resolved) {
            return count++;
          }
        });
        /* return count; */

        /* 使用数组ES6数组reduce方法进行统计 */
        count = 0;
        // this.lists.reduce(回调函数, 统计起点);
        /* 
          统计起点从0开始，回调函数有两个参数
          回调函数的调用次数和数组中元素总数有关系，数组中有三个元素，则这个回调函数被调用3次
          a是上一个回调函数的返回值
          b是当前被统计的对象，bug对象
        */
        return this.lists.reduce((a, b) => a + (b.resolved ? 1 : 0), 0);
      }
    }
  };
</script>

<style scoped>
  footer {
    margin-top: 10px;
  }
  span {
    color: lightgreen;
  }
</style>