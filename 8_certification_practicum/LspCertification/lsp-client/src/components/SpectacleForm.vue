<script>
import ky from "ky";

export default {
    data() {
        return {
            distributors: []
        }
    },
    emits: {
        submit: (formData) => {
            if (formData) {
                return true
            } else {
                console.warn('Invalid submit event payload!')
                return false
            }
        }
    },
    props: {
        formData: {
            type: Object,
            // Object or array defaults must be returned from
            // a factory function. The function receives the raw
            // props received by the component as the argument.
            default() {
                return {
                    spectacleCode: "",
                    spectacleType: "",
                    spectacleBrand: "",
                    price: 0,
                    stock: 0,
                    distributorId: "",
                }
            }
        },
    },
    async mounted() {
        await this.getDistributors();
    },
    methods: {
        submit() {
            this.$emit('submit', this.formData)
        }, 
        async getDistributors() {
            this.distributors = await ky.get('/api/distributors').json()
        }
    }
}
</script>

<template>
    <div class="flex flex-col justify-start items-stretch">
        <label class="input font-bold h-16 input-bordered flex items-center gap-5">
            Spectacle Code
            <input v-model="formData.spectacleCode" type="text" class="grow font-normal" placeholder="spectacle code" />
        </label>
        <label class="input font-bold h-16 input-bordered flex items-center gap-5">
            Spectacle Type
            <input v-model="formData.spectacleType" type="text" class="grow font-normal" placeholder="spectacle type" />
        </label>
        <label class="input font-bold h-16 input-bordered flex items-center gap-5">
            Spectacle Brand
            <input v-model="formData.spectacleBrand" type="text" class="grow font-normal" placeholder="spectacle brand" />
        </label>
        <label class="input font-bold h-16 input-bordered flex items-center gap-5">
            Price
            <input v-model="formData.price" type="number" class="grow font-normal" placeholder="price" />
        </label>
        <label class="input font-bold h-16 input-bordered flex items-center gap-5">
            Stock
            <input v-model="formData.stock" type="text" class="grow font-normal" placeholder="stock" />
        </label>
        <label class="input font-bold h-16 input-bordered flex items-center gap-5">
            Distributor
            <select class="select w-full max-w-xs" v-model="formData.distributorId">
                <option v-for="option in distributors" :value="option.distributorId">
                    {{ option.distributorName }}
                </option>
            </select>
        </label>
        <div class="mt-10">
            <button class="btn btn-neutral" @click="submit()">Submit</button>
        </div>
    </div>
</template>