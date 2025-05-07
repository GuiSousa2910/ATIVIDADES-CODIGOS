import { useNavigate } from "react-router-dom"
import { ENDPOINTS } from "../../constantes/endpoints"
import { ROUTERS } from "../../constantes/routers"
import { api } from "../../http/axios-instance"
import { Button } from "../../componentes/Button"
import { useRef } from "react"


export const Login = () => {
  
  const navigate = useNavigate()

  const email = useRef(null);
  const senha = useRef(null)

  const realizarLogin = () => {
    api
      .post(ENDPOINTS.LOGIN, {
        email:email.current.value,
        senha:senha.current.value,
      })
      .then(response => {
        sessionStorage.setItem('token', response.data.token)
        sessionStorage.setItem('nome', response.data.nome)
        navigate(ROUTERS.POSTS)
      })
      .catch(() => {
        console.error('Houve um erro ao realizar o login')
      })
  }

  return (
    <>
      <main className="grid grid-cols-6 grid-rows-1 h-[calc(100vh-5rem)] bg-ft-background">
        <section className="col-span-3 h-full w-9/12 mx-auto flex flex-col gap-4 justify-center">
          <div>
            <h1 className="font-black mb-2 text-2xl">Bem vindo!</h1>
            <h2 className="font-light text-[1.2rem]">Faça login para acessar o Forum.</h2>
          </div>

          <p className="text-xs font-light">
            Não tem uma conta?{' '}
            <b className="text-ft-secondary font-bold underline" onClick={() => navigate(ROUTERS.SIGNUP)}>
              Cadastre-se agora
            </b>
            .
          </p>

          <form className="flex flex-col gap-y-4 w-full">
            <div className="flex flex-col gap-y-2">
              <label className="text-ft-gray-white">Email</label>
              <input
                type={'email'}
                ref={email}
                placeholder={'Insira seu e-mail'}
                className="border border-gray-300 px-4 py-2 rounded focus:outline-none focus:ring-2 focus:ring-ft-primary"
              />
            </div>
            <div className="flex flex-col gap-y-2">
              <label className="text-ft-gray-white">Senha</label>
              <input
                type={'password'}
                ref={senha}
                placeholder={'Insira sua senha'}
                className="border border-gray-300 px-4 py-2 rounded focus:outline-none focus:ring-2 focus:ring-ft-primary"
              />
            </div>
            <Button type="button" className="w-max mx-auto" onClick={realizarLogin}>
              Entrar
            </Button>
          </form>
        </section>
        <section className="col-span-3 h-full">
          <img src="/images/background-login.png" alt="" className="h-full w-full object-cover rounded-l-3xl" />
        </section>
      </main>
    </>
  )
}
