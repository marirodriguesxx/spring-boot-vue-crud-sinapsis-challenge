<template>
  <button :type="type" :class="buttonClass" @click="handleClick">
    <slot></slot>
  </button>
</template>

<script setup lang="ts">
import { defineProps, defineEmits } from 'vue'

interface Props {
  type?: 'button' | 'submit' | 'reset'
  class?: string
}

const props = defineProps<Props>()
const emits = defineEmits(['click'])

const buttonClass = props.class || 'default-button-class'

const handleClick = (event: Event) => {
  emits('click', event)
}
</script>

<style scoped>
.default-button-class {
  background-color: #007bff;
  padding: 10px 20px;
  font-size: 16px;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.default-button-class:hover {
  background-color: #0056b3;
}

.button-group {
  display: flex;
  justify-content: space-evenly;
  width: 80%;
  margin-top: 1rem;
}
</style>
