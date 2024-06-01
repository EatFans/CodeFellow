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
import GeneralDiscussionNode from "@/components/home/nodes/GeneralDiscussionNode.vue";
import ProgrammingTechnologiesNode from "@/components/home/nodes/ProgrammingTechnologiesNode.vue";
import DevToolsPracticesNode from "@/components/home/nodes/DevToolsPracticesNode.vue";
import SpecializedDevelopmentNode from "@/components/home/nodes/SpecializedDevelopmentNode.vue";
import ProjectCareerNode from "@/components/home/nodes/ProjectCareerNode.vue";
import LearningResourcesNode from "@/components/home/nodes/LearningResourcesNode.vue";
import TechQACommunityNode from "@/components/home/nodes/TechQACommunityNode.vue";
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