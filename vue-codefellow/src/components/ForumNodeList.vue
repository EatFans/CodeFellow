<!-- 版块节点列表组件 -->
<template>
  <div class="forum-node-list-content">
    <AnnouncementNode />
    <LanguagesNode class="node"/>
    <WebDevelopment class="node"/>
    <MobileDevelopment class="node"/>
    <DatabasesNode class="node" />
    <GameDevelopmentNode class="node" />
    <AINode class="node" />
    <ProblemNode class="node"  />
  </div>
</template>

<script>
import AnnouncementNode from "@/components/nodes/AnnouncementNode.vue"
import LanguagesNode from "@/components/nodes/LanguagesNode.vue";
import WebDevelopment from "@/components/nodes/WebDevelopmentNode.vue";
import MobileDevelopment from "@/components/nodes/MobileDevelopmentNode.vue";
import DatabasesNode from "@/components/nodes/DatabasesNode.vue";
import GameDevelopmentNode from "@/components/nodes/GameDevelopmentNode.vue";
import AINode from "@/components/nodes/AINode.vue";
import ProblemNode from "@/components/nodes/ProblemNode.vue";
export default {
  components:{
    AnnouncementNode,
    LanguagesNode,
    WebDevelopment,
    MobileDevelopment,
    DatabasesNode,
    GameDevelopmentNode,
    AINode,
    ProblemNode
  }
}
</script>

<style scoped>
.forum-node-list-content {
  width: auto;
  height: auto;
}

</style>