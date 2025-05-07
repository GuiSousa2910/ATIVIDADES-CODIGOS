import React from 'react'
import { Link } from 'react-router-dom'
import { ROUTERS } from '../constantes/routers'
import { Button } from './Button'

export const Header = () => (
  <header className="flex justify-between px-10 py-4 ">
    <div className="flex flex-1">
      <Link to={ROUTERS.HOME} className="flex items-center gap-x-2">
        <img src="/images/logo.png" alt="" />
        <h1>
          Forum<b>Tech</b>
        </h1>
      </Link>
    </div>

    <div className="flex gap-x-4 justify-center items-center">
      {sessionStorage.nome && <h2>Olá, Pedro!</h2>}
      {!sessionStorage.nome && (
        <>
          <Button variant="ghost" redirect={ROUTERS.LOGIN}>
            Login
          </Button>
          <Button redirect={ROUTERS.SIGNUP}>Cadastro</Button>
        </>
      )}
    </div>
  </header>
)
