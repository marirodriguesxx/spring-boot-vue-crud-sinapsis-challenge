import { ref } from 'vue'

export function useLogin() {
  const username = ref('')
  const password = ref('')

  const handleSubmit = () => {
    console.log('Usuário:', username.value)
    console.log('Senha:', password.value)
    // Aqui você pode adicionar a lógica para lidar com o login, como chamar uma API
  }

  return {
    username,
    password,
    handleSubmit
  }
}
