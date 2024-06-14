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
import GeneralDiscussionNode from "@/layouts/home/nodes/GeneralDiscussionNode.vue";
import ProgrammingTechnologiesNode from "@/layouts/home/nodes/ProgrammingTechnologiesNode.vue";
import DevToolsPracticesNode from "@/layouts/home/nodes/DevToolsPracticesNode.vue";
import SpecializedDevelopmentNode from "@/layouts/home/nodes/SpecializedDevelopmentNode.vue";
import ProjectCareerNode from "@/layouts/home/nodes/ProjectCareerNode.vue";
import LearningResourcesNode from "@/layouts/home/nodes/LearningResourcesNode.vue";
import TechQACommunityNode from "@/layouts/home/nodes/TechQACommunityNode.vue";
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