<template>
  <div class="fruit">
    <h1>部分</h1>
    <ul>
      <li>{{roots}}</li>
      <li>{{leaves}}</li>
      <li>{{fruit}}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name : 'PartComponent',
  props : ['roots', 'leaves', 'fruit']
}
</script>