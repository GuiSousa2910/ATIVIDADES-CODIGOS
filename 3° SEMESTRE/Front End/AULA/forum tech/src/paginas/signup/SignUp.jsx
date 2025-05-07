
import React, { useRef, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { api } from '../../http/axios-instance'
import { Button } from "../../componentes/Button"
import { ENDPOINTS } from '../../constantes/endpoints'
import {ROUTERS} from '../../constantes/routers'

export const SignUp = () => {
  const nome = useRef(null)
  const email = useRef(null)
  const senha = useRef(null)
  const [error, setError] = useState([])

  const navigate = useNavigate()
  const cadastrarUsuario = () => {
    console.log("Teste")
    api
      .post(ENDPOINTS.SIGNUP, {
        nome: nome.current.value,
        email: email.current.value,
        senha: senha.current.value
      })
      .then(() => {
        alert('Usuário cadastrado com sucesso')
        navigate(ROUTERS.LOGIN)
      })
      .catch(error => {
        console.log(error)
        if (error?.response?.status === 409) {
          setError(['Usuário já cadastrado'])
          return
        }

        if (error?.response?.status === 400) {
          console.log(error)
          const message = error.response.data.erros.map(erro => erro.message)
          setError(message)
        }
      })
  }

  return (
    <main className="grid grid-cols-6 grid-rows-1 h-[calc(100vh-5rem)] bg-ft-background">
      <section className="col-span-3 h-full w-9/12 mx-auto flex flex-col gap-4 justify-center">
        <div>
          <h1 className="font-black mb-2 text-2xl">Crie sua conta</h1>
          <h2 className="font-light text-[1.2rem]">Crie uma conta para acessar o Forum.</h2>
        </div>

        <p className="text-xs font-light">
          Já possui uma conta? <b className="text-ft-secondary font-bold underline">Acesse aqui</b>.
        </p>

        <form className="flex flex-col gap-y-4 w-full">
          <div className="flex flex-col gap-y-2">
            <label className="text-ft-gray-white">Nome</label>
            <input
              type={'text'}
              placeholder={'Insira seu nome'}
              ref={nome}
              className="border border-gray-300 px-4 py-2 rounded focus:outline-none focus:ring-2 focus:ring-ft-primary"
            />
          </div>
          <div className="flex flex-col gap-y-2">
            <label className="text-ft-gray-white">Email</label>
            <input
              type={'email'}
              placeholder={'Insira seu e-mail'}
              ref={email}
              className="border border-gray-300 px-4 py-2 rounded focus:outline-none focus:ring-2 focus:ring-ft-primary"
            />
          </div>
          <div className="flex flex-col gap-y-2">
            <label className="text-ft-gray-white">Senha</label>
            <input
              type={'password'}
              placeholder={'Insira sua senha'}
              ref={senha}
              className="border border-gray-300 px-4 py-2 rounded focus:outline-none focus:ring-2 focus:ring-ft-primary"
            />
          </div>
          <Button type="button" className="w-max mx-auto" onClick={cadastrarUsuario}>
            Cadastrar
          </Button>
        </form>
        <ul className="list-disc">
          {error.map((el, key) => (
            <li key={key} className="text-xs text-red-600">
              {el}
            </li>
          ))}
        </ul>
      </section>
      <section className="col-span-3 h-full">
        <img src="/images/background-signup.png" alt="" className="h-full w-full object-cover rounded-l-3xl" />
      </section>
    </main>
  )
}
