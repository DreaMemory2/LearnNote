<template>
  <div class="container">

    <BugHeader 
      @saveBugCallback="saveBugCallback" ref="bugHeader"
    />

    <BugList 
      :lists="lists" 
      @isSelectAllCallback="isSelectAllCallback"
    />

    <BugFooter 
      :lists="lists" 
      @clearResolvedCallback="clearResolvedCallback"
    />
  </div>
</template>

<script>
  import BugHeader from './components/BugHeader.vue';
  import BugList from './components/BugList.vue';
  import BugFooter from './components/BugFooter.vue';

  export default {
    name: 'ApplicationComponent',
    components : {
      BugHeader,
      BugList,
      BugFooter
    },
    methods : {
      /* 保存Bug回调方法 */
      saveBugCallback(bug) {
        // 父绑定，子触发
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
      updateContentCallback(id, newContent) {
        this.lists.forEach((bug) => {
          if (bug.id === id) {
            bug.content = newContent;
            return
          };
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
          {id:'01', content:'BUG描述信息100', resolved: false},
          {id:'02', content:'BUG描述信息200', resolved: true},
          {id:'03', content:'BUG描述信息300', resolved: false},
        ],
      };
    },
    mounted() {
      // 向全局事件总线对象上绑定事件
      this.$bus.$on('modifyResolvedCallback', this.modifyResolvedCallback);
      this.$bus.$on('deleteByIdCallback', this.deleteByIdCallback);
      this.$bus.$on('updateContentCallback', this.updateContentCallback);
    },
    beforeDestroy() {
      // 当前组件被销毁之前，要手动将绑定在总线上的事件解绑掉
      this.$bus.$off(['modifyResolvedCallback', 'deleteByIdCallback', 'updateContentCallback']);
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
    margin: 15px;
    padding: 15px;
    font-size: 15px;
    border-radius: 5px;
    border: 2px solid lightgreen;
    box-shadow: 2px 2px 5px 4px rgba(0, 128, 0, 0.3);
  }
  .green-button {
    padding: 5px;
    margin-top: 5px;
    font-weight: bold;
    color: lightgreen;
    border-radius: 5px;
    background-color: white;
    border: 2px solid lightgreen;
  }
  .green-button:hover {
    padding: 4px;
    color: white;
    font-size: 15px;
    font-weight: bold;
    border: 2px solid lightgreen;
    background-color: rgb(172, 248, 172);
  }
</style>