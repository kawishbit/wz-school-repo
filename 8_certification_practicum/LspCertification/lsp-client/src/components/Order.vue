<script setup>
import {onMounted, reactive, ref} from "vue";

const items = ref([])
onMounted(async () => {
    items.value = await (await fetch("/api/spectacles/min")).json();
})
</script>

<template>
    <div class="container flex flex-col justify-start items-stretch">
        <div class="overflow-x-auto mt-5">
            <table class="table">
                <!-- head -->
                <thead>
                <tr>
                    <th></th>
                    <th>Code</th>
                    <th>Lens Type</th>
                    <th>Lens Brand</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Distributor</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <!-- row 1 -->
                <tr v-for="(item,i) in items">
                    <th>{{i+1}}</th>
                    <td>{{item.spectacleCode}}</td>
                    <td>{{item.spectacleType}}</td>
                    <td>{{item.spectacleBrand}}</td>
                    <td>{{item.price}}</td>
                    <td>{{item.stock}}</td>
                    <td>{{item.distributor}}</td>
                    <td><button @click="console.log('clicked')"  class="btn btn-neutral">Order</button></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>