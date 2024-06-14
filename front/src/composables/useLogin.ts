import { ref } from 'vue'

export function useLogin() {
  const username = ref('')
  const password = ref('')

  const handleSubmit = () => {
    console.log('Usuário:', username.value)
    console.log('Senha:', password.value)
  }

  return {
    username,
    password,
    handleSubmit
  }
}
