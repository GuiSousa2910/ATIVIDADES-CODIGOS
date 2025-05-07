import React from 'react'
import { Outlet } from 'react-router-dom'
import { Header } from './Header'


export const ContainerBox = () => (
  <div className="mx-auto max-w-[1366px]">
    <Header />
    <Outlet />
  </div>
)
