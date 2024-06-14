<script setup lang="ts">
import LoginBox from '../components/LoginBox.vue'
</script>

<template>
  <div class="login-page">
    <LoginBox />
  </div>
</template>

<style scoped>
.login-page {
  height: 100%;
  width: 100%;
  background: url('src/assets/electric-grid.jpg');
  /* background-size: cover; */
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
