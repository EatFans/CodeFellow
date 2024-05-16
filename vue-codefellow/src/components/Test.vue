<template>
  <h3>内联处理器</h3>
  <button @click="addCount">Add</button>
  <p>{{count}}</p>
</template>

<script>
export default {
  data() {
    return {
      count: 0
    }
  },
  methods:{
    addCount(){
      this.count += 1
    }
  }
}

</script>
