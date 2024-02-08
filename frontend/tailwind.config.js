/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
    'node_modules/flowbite-react/lib/esm//*.js'
  ],
  theme: {
    extend: {},
    colors: {
      fbblue: '#1877F2',
      violet: 'rgb(56 189 248)'
    }
  },
  plugins: [require('tailwindcss-animate'),require('flowbite/plugin')],
}

