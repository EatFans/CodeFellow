<!-- 版块节点列表组件 -->
<template>
  <div class="forum-node-list-container">
    <ForumNode />
  </div>
</template>

<script>
import ForumNode from "@/components/ForumNode.vue"

export default {
  components:{
    ForumNode
  }
}
</script>

<style scoped>
.forum-node-list-container {
  width: auto;
  height: 1900px;
  margin-top: 20px;
  background: firebrick;
}
</style>