<template>
  <div class="login-box">
    <form @submit.prevent="handleLogin">
      <div class="form-group">
        <label for="username">Usuário:</label>
        <input type="text" id="username" v-model="username" required />
      </div>
      <div class="form-group">
        <label for="password">Senha:</label>
        <input type="password" id="password" v-model="password" required />
      </div>
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router'
import { useLogin } from '../composables/useLogin'

const { username, password, handleSubmit } = useLogin()
const router = useRouter()

const handleLogin = async () => {
  await handleSubmit() // Supondo que isso realiza a lógica de login
  router.push({ name: 'subestacoes' })
}
</script>

<style scoped>
.login-box {
  max-width: 400px;
  width: 100%;
  padding: 2em;
  color: black;
  background: white; /* Fundo branco */
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Sombra suave */
  margin: auto;
}

.form-group {
  margin-bottom: 1em;
}

.form-group label {
  display: block;
  margin-bottom: 0.5em;
}

.form-group input {
  width: 100%;
  padding: 0.5em;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  width: 100%;
  padding: 0.5em;
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  color: white;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
