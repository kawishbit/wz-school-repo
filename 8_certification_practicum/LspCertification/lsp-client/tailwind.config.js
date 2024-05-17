/** @type {import('tailwindcss').Config} */
import daisyui from "daisyui"

export default {
    purge: ['./index.html', './src/**/*.{vue,js,ts,jsx,tsx}'],
    content: ['./src/**/*.{vue,js,ts}'],
    theme: {
        extend: {},
    },
    plugins: [daisyui],
}

