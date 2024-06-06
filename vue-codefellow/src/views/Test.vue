<template>
  <div class="test">
    <PageTitle title="测试" />

  </div>
</template>

<script>

import {defineComponent} from "vue";
import PageTitle from "@/components/PageTitle.vue";

export default defineComponent({
  components: {PageTitle}
})
</script>

<style scoped>
.test {
  height: 47px;
  width: 100%;
  display: flex;
  margin-left: 100px;
}
</style>