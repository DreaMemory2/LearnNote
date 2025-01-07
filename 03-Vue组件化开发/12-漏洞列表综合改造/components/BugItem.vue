<template>
  <tr>
    <td><input type="checkbox" :checked="bug.resolved" @change="modifyResolved(bug.id)"></td>
    <!-- <td><input type="checkbox" v-model="resolved"></td> -->
    <td class="info">
      <span v-show="!bug.editState" class="content" @click="enterEdit(bug)">{{bug.content}}</span>
      <input ref="inputContent" v-show="bug.editState" type="text" class="text" :value="bug.content" @blur="updateContent(bug, $event)">
    </td>
    <td><button class="green-button" @click="deleteById(bug.id)">删除</button></td>
  </tr>
</template>

<script>
  export default {
    name : 'BugItem',
    props : ['bug'],
    methods : {
      modifyResolved(id) {
        // 触发事件
        this.$bus.$emit('modifyResolvedCallback', id);
      },
      deleteById(id) {
        // 触发事件
        this.$bus.$emit('deleteByIdCallback', id);
      },
      enterEdit(bug) {
        if (bug.hasOwnProperty('editState')) {
          bug.editState = true;
        } else {
          this.$set(bug, 'editState', true);
        }
        this.$nextTick(function(){
          this.$refs.inputContent.focus();
        });
      },
      updateContent(bug, e) {
        let newContent = e.target.value.trim();
        if (!newContent) return;
        // 触发事件
        this.$bus.$emit('updateContentCallback', bug.id, newContent);
        bug.editState = false;
      }
    }
  };
</script>

<style scoped>
  table tbody tr{
    color: green;
  }
  table tbody tr:nth-child(odd) {
    background-color: rgb(227, 255, 227);
  }
  table tbody tr:hover {
    background-color: rgb(190, 255, 190);
  }
  td {
    border: 1px solid lightgreen;
    text-align: center;
    padding: 5px 0;
  }
  input[type="text"].text {
    appearance: none;
    outline:0;
    padding: 5px;
    font-weight: bold;
    font-size: 15px;
    color: rgb(55, 137, 55);
    width: auto;
    border: 2px solid lightgreen;
    background-color: #fff;
    border-radius: 5px;
  }
</style>