<template>
    <v-card outlined>
        <v-card-title>
            ChangePassword
        </v-card-title>

        <v-card-text>
            <UUID offline label="AccountId" v-model="value.accountId" :editMode="editMode" @change="change"/>
            <Password offline label="NewPassword" v-model="value.newPassword" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="changePassword"
            >
                ChangePassword
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
        name: 'ChangePasswordCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.accountId = {};
            this.value.newPassword = {};
        },
        watch: {
        },
        methods: {
            changePassword() {
                this.$emit('changePassword', this.value);
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

