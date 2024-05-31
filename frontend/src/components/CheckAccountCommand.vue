<template>
    <v-card outlined>
        <v-card-title>
            CheckAccount
        </v-card-title>

        <v-card-text>
            <UUID offline label="AccountId" v-model="value.accountId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="checkAccount"
            >
                CheckAccount
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CheckAccountCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.accountId = {};
        },
        watch: {
        },
        methods: {
            checkAccount() {
                this.$emit('checkAccount', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

