<script>
import './assets/main.css'

export default {}
</script>

<template>
    <div class="flex flex-col justify-start items-center">
        <h1 class="leading-3 my-2">Kawish Behzad Mazhar</h1>
        <p>200401075</p>
        <div class="mt-10 flex flex-row">
            <RouterLink :to="{name:'home'}">
                <button class="btn btn-neutral mx-2">Home</button>
            </RouterLink>
            <RouterLink :to="{name:'admin'}">
                <button class="btn btn-neutral mx-2">Admin</button>
            </RouterLink>
            <RouterLink :to="{name:'order'}">
                <button class="btn btn-neutral mx-2">Order</button>
            </RouterLink>
        </div>
        <div class="flex flex-col justify-start items-stretch my-10">
            <RouterView/>
        </div>
    </div>
</template>

<style>
input::placeholder {
    opacity:0.2
}
</style>