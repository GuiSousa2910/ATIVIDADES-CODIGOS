import React from 'react'
import { useNavigate } from 'react-router-dom'
import { cn } from '../uteis/cn'

export const buttonVariants = {
  base: 'transition-colors duration-100 font-bold px-7 py-2 rounded text-sm',
  primary: 'bg-ft-primary hover:bg-ft-secondary text-white',
  ghost: 'hover:bg-ft-secondary hover:text-white text-ft-secondary border border-ft-secondary',
  secondary: 'bg-ft-secondary hover:bg-ft-primary text-white'
}

export const Button = ({ children, variant = 'primary', className, redirect, onClick, ...props }) => {
  const navigate = useNavigate()

  return (
    <button
      type="button"
      {...props}
      className={cn(buttonVariants.base, buttonVariants[variant], className)}
      onClick={e => {
        if (redirect) navigate(redirect)
        onClick && onClick(e)
      }}>
      {children}
    </button>
  )
}
