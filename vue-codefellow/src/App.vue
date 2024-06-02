<template>
  <HeaderBar />
  <div class="main">
    <router-view></router-view>
  </div>
  <Footer />
</template>

<script setup>
import HeaderBar from "@/components/HeaderBar.vue";
import Footer from "@/components/Footer.vue";
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
</style>
