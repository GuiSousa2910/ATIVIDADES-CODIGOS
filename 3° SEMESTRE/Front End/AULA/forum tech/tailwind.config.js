/** @type {import('tailwindcss').Config} */
export default {
  content: ['./index.html', './src/**/*.{js,jsx}'],
  theme: {
    extend: {
      colors: {
        ft: {
          primary: '#FFA629',
          secondary: '#EF7800',
          tertiary: '#1682FD',
          gray: {
            white: '#808080',
            dark: '#EAEAEA'
          },
          'primary-ghost': '#FCF4EC',
          background: '#FAFAFA'
        }
      }
    }
  },
  plugins: []
}
