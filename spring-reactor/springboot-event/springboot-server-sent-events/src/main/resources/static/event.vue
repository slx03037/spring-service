<template>
  <div>
    <h1>Server-Sent Events</h1>
    <ul>
      <li v-for="message in messages" :key="message.id">{{ message.content }}</li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue';
import { SseClient } from './sseClient';


const messages = ref([]);

const sseClient = new SseClient((event) => {
  const data = JSON.parse(event.data);
  messages.value.push(data);
});

onMounted(() => {
  sseClient.connect();
});

onUnmounted(() => {
  sseClient.disconnect();
});
</script>

<style scoped>
/* Add your styles here */
</style>