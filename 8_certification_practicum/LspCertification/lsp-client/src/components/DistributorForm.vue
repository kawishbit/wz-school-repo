<script>
export default {
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
                    distributorCode: "",
                    distributorName: "",
                    address: "",
                    emailAddress: "",
                    phoneNumber: "",
                    contactPerson: "",
                }
            }
        },
    },
    methods: {
        submit() {
            this.$emit('submit', this.formData)
        }
    }
}
</script>

<template>
    <div class="flex flex-col justify-start items-stretch">
        <label class="input font-bold h-16 input-bordered flex items-center gap-5">
            Distributor Code
            <input v-model="formData.distributorCode" type="text" class="grow font-normal" placeholder="distributor code" />
        </label>
        <label class="input font-bold h-16 input-bordered flex items-center gap-5">
            Distributor Name
            <input v-model="formData.distributorName" type="text" class="grow font-normal" placeholder="distributor name" />
        </label>
        <label class="input font-bold h-16 input-bordered flex items-center gap-5">
            Address
            <input v-model="formData.address" type="text" class="grow font-normal" placeholder="address" />
        </label>
        <label class="input font-bold h-16 input-bordered flex items-center gap-5">
            Email
            <input v-model="formData.emailAddress" type="text" class="grow font-normal" placeholder="email" />
        </label>
        <label class="input font-bold h-16 input-bordered flex items-center gap-5">
            Phone Number
            <input v-model="formData.phoneNumber" type="text" class="grow font-normal" placeholder="phone number" />
        </label>
        <label class="input font-bold h-16 input-bordered flex items-center gap-5">
            Contact Person
            <input v-model="formData.contactPerson" type="text" class="grow font-normal" placeholder="contact person" />
        </label>
        <div class="mt-10">
            <button class="btn btn-neutral" @click="submit()">Submit</button>
        </div>
    </div>
</template>