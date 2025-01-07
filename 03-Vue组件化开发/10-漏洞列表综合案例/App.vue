<template>
  <div class="container">
    <BugHeader v-bind:saveBugCallback="saveBugCallback"></BugHeader>
    <BugList v-bind:lists="lists" :modifyResolvedCallback="modifyResolvedCallback" :deleteByIdCallback="deleteByIdCallback" :isSelectAllCallback="isSelectAllCallback"></BugList>
    <BugFooter v-bind:lists="lists" :clearResolvedCallback="clearResolvedCallback"></BugFooter>
  </div>
</template>

<script>
  import BugHeader from './components/BugHeader.vue';
  import BugList from './components/BugList.vue';
  import BugFooter from './components/BugFooter.vue';

  export default {
    name: 'Application',
    components : {
      BugHeader,
      BugList,
      BugFooter
    },
    methods : {
      /* 保存Bug回调方法 */
      saveBugCallback(bug) {
        this.lists.unshift(bug);
      },
      /* 修改某个Bug对象得到resolved的值 */
      modifyResolvedCallback(id) {
        this.lists.forEach(bug => {
          if (bug.id === id) {
            bug.resolved = !bug.resolved;
          }
        });
      },
      /* 删除数组中的某个bug对象：根据id删除 */
      deleteByIdCallback(id) {
        /* 注意：filter方法返回的是一个全新的数组 */
        this.lists = this.lists.filter((bug) => {
          return bug.id !== id;
        });
      },
      isSelectAllCallback(flag) {
        this.lists.forEach((bug) => {
          bug.resolved = flag;
        });
      },
      // 清空已解决
      clearResolvedCallback() {
        this.lists = this.lists.filter((bug) => {
          return !bug.resolved;
        });
      }
    },
    data() {
      return {
        lists : [
          {id:1, content:'BUG描述信息01', resolved: true},
          {id:2, content:'BUG描述信息02', resolved: false},
          {id:3, content:'BUG描述信息03', resolved: false},
        ],
      };
    }
  };
</script>

<style>
  * {
    padding: 0;
    margin: 0;
  }
  .container {
    position: absolute;
    font-size: 15px;
    border: 2px solid lightgreen;
    margin: 15px;
    padding: 15px;
    box-shadow: 2px 2px 5px 4px rgba(0, 128, 0, 0.3);
  }
</style>