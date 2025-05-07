import axios from 'axios'

const axiosInstance = axios.create({
  baseURL: import.meta.env.VITE_API_URL
})

axiosInstance.interceptors.request.use(
  config => {
    const token = sessionStorage.getItem('token')
    const isExcludedRoute = ['/usuarios/login', '/usuarios/'].some(route => config.url.includes(route))

    if (token && !isExcludedRoute) {
      config.headers.Authorization = `Bearer ${token}`
    }
    return config
  },
  error => Promise.reject(error)
)

export const api = axiosInstance