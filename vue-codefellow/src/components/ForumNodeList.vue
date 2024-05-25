<!-- 版块节点列表组件 -->
<template>
  <div class="forum-node-list-content">
    <GeneralDiscussionNode />
    <ProgrammingTechnologiesNode />
    <DevToolsPracticesNode />
    <SpecializedDevelopmentNode />
    <ProjectCareerNode />
    <LearningResourcesNode />
    <TechQACommunityNode />
  </div>
</template>

<script>
import GeneralDiscussionNode from "@/components/nodes/GeneralDiscussionNode.vue";
import ProgrammingTechnologiesNode from "@/components/nodes/ProgrammingTechnologiesNode.vue";
import DevToolsPracticesNode from "@/components/nodes/DevToolsPracticesNode.vue";
import SpecializedDevelopmentNode from "@/components/nodes/SpecializedDevelopmentNode.vue";
import ProjectCareerNode from "@/components/nodes/ProjectCareerNode.vue";
import LearningResourcesNode from "@/components/nodes/LearningResourcesNode.vue";
import TechQACommunityNode from "@/components/nodes/TechQACommunityNode.vue";
export default {
  components:{
    GeneralDiscussionNode,
    ProgrammingTechnologiesNode,
    DevToolsPracticesNode,
    SpecializedDevelopmentNode,
    ProjectCareerNode,
    LearningResourcesNode,
    TechQACommunityNode
  }
}
</script>

<style scoped>
.forum-node-list-content {
  width: auto;
  height: auto;
}

</style>