import React from 'react'
import { Outlet } from 'react-router-dom'
import { SideBar } from './Sidebar'

export const ContainerUser = () => (
  <div className="flex">
    <SideBar />
    <Outlet />
  </div>
)