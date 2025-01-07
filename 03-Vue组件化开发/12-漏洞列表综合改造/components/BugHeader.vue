<template>
  <header>
    <textarea cols="105" rows="4" v-model="content" placeholder="请输入BUG的描述信息" class="text"></textarea>
    <br>
    <button class="green-button" v-on:click="addBugInfo">保存</button>
  </header>
</template>

<script>
  export default {
    name : 'BugHeader',
    data() {
      return {
        // 获取content
        content: ''
      };
    },
    methods : {
      addBugInfo() {
        if (!this.content.trim()) return;
        // 创建bug对象
        let bug = {id:Date.now(), content:this.content, resolved:false};
        // 子组件触发，且添加到BugList数组当中
        /* this.saveBugCallback(bug); */
        this.$emit('saveBugCallback', bug);
        // 清空文本域，清空内容
        this.content = ''
      }
    }
  };
</script>

<style scoped>
  header {
    margin-bottom: 20px;
  }

  textarea {
    position: relative;
    font-weight: bold;
    resize: none;
    font-size: 15px;
    padding: 5px;
    background-color: #fff;
    border: 2px solid lightgreen;
    border-radius: 5px;
  }

  textarea:focus {
    color: rgb(55, 137, 55);
    padding: 5px;
    outline: none;
    background-color: #ebfaed;
    border: 2px solid #3cf036;
  }

  textarea::placeholder {
    font-family: '黑体' serif;
    font-size: 15px;
    color: #3cf036;
  }
</style>