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
    props: ['saveBugCallback'],
    methods : {
      addBugInfo() {
        if (!this.content.trim()) return;
        // 创建bug对象
        let bug = {id:Date.now(), content:this.content, resolved:false};
        // 添加到BugList数组当中
        this.saveBugCallback(bug);
        // 清空文本域，清空内容
        this.content = ''
      }
    }
  };
</script>

<style>
  header {
    margin-bottom: 20px;
  }

  textarea {
    position: relative;
    font-weight: bold;
    resize: none;
    font-size: 15px;
    text-align: left;
    padding: 5px;
    background-color: #fff;
    border: 2px solid lightgreen;
    border-radius: 4px;
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

  .green-button {
    font-weight: bold;
    color: lightgreen;
    border: 2px solid lightgreen;
    padding: 5px;
    margin-top: 5px;
    background: #fff;
  }

  .green-button:hover {
    font-weight: bold;
    color: white;
    font-size: 15px;
    border: 2px solid lightgreen;
    padding: 4px;
    background: greenyellow;
  }
</style>