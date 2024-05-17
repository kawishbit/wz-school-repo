<script setup>
</script>

<template>

    <div class="flex flex-col justify-start items-center">

        <div class="mt-10 flex flex-row">
            <RouterLink :to="{name:'distributor'}">
                <button class="btn btn-neutral mx-2">Distributor</button>
            </RouterLink>
            <RouterLink :to="{name:'spectacle'}">
                <button class="btn btn-neutral mx-2">Spectacle</button>
            </RouterLink>
        </div>

        <div class="flex flex-col justify-start items-stretch my-10">
            <RouterView/>
        </div>
    </div>
</template>