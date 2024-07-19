<template>
  <HeaderBar />
  <CommunicationContent />
  <Footer />
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue";
import Footer from "@/components/Footer.vue";
import CommunicationContent from "@/layouts/communication/CommunicationContent.vue";

export default {
  name: "CommunicationPage",
  components: {
    CommunicationContent,
    HeaderBar,
    Footer
  }

}
</script>

<style scoped>

</style>