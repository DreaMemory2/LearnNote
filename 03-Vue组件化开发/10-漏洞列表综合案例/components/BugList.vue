<template>
  <main v-show="lists.length">
    <table>
      <thead>
        <tr>
          <th class="select">全选 <input type="checkbox" v-bind:checked="isSelectAll" v-on:change="selectAll($event)"/></th>
          <th class="content">Bug描述信息</th>
          <th class="operate">操作</th>
        </tr>
      </thead>
      <tbody>
        <BugItem v-for="bug in lists" :key="bug.id" v-bind:id="bug.id" v-bind:content="bug.content" v-bind:resolved="bug.resolved" :modifyResolvedCallback="modifyResolvedCallback" :deleteByIdCallback="deleteByIdCallback"></BugItem>
      </tbody>
    </table>
  </main>
</template>

<script>
import BugItem from './BugItem.vue'

export default {
  name: 'BugList',
  props : ['lists', "modifyResolvedCallback", "deleteByIdCallback", "isSelectAllCallback"],
  components : {BugItem},
  methods : {
    selectAll(e) {
      this.isSelectAllCallback(e.target.checked);
    }
  },
  computed : {
    resolvedCount() {
      return this.lists.reduce((a, b) => a + (b.resolved ? 1 : 0), 0);
    },
    isSelectAll() {
      return this.lists.length === this.resolvedCount && this.lists.length > 0 
    }
  }
}
</script>

<style>

  table {
    position: relative;
    width: 100%;
    border-collapse: collapse;
  }
  table caption {
    font-size: 1em;
    font-weight: bold;
    margin: 1em 0;
  }
  .select, .operate {
    width: 100px;
  }
  th {
    border: 1px solid lightgreen;
    text-align: text;
    padding: 5px 0;
  }
  table thead tr {
    background: rgb(143, 226, 143);
    color: #fff;
  }

  input {
    vertical-align: middle;
    width: 16px;
    height: 16px;
  }   
  input[type="checkbox"] {
    /* 移除默认样式 */
    -webkit-appearance: none;
    border: 1px solid #999;
    outline: none;
    border-radius: 2px;
    border: 2px solid lightgreen;
    background-color: #FFF; 
    position: relative;
  }

  /* 显示对勾 */
  input[type="checkbox"]:checked::after {
    content: "";
    display: block;
    background-color: greenyellow;
    width: 13px;
    height: 13px;
    position: absolute;
    background-image: url('../assets/check.svg');
    background-position: center;
    background-repeat: no-repeat;
    background-size: contain;
  }
</style>