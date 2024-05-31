
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import CustomerManagementCustomerAccountManager from "./components/listers/CustomerManagementCustomerAccountCards"
import CustomerManagementCustomerAccountDetail from "./components/listers/CustomerManagementCustomerAccountDetail"

import AccountManagementBankAccountManager from "./components/listers/AccountManagementBankAccountCards"
import AccountManagementBankAccountDetail from "./components/listers/AccountManagementBankAccountDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/customerManagements/customerAccounts',
                name: 'CustomerManagementCustomerAccountManager',
                component: CustomerManagementCustomerAccountManager
            },
            {
                path: '/customerManagements/customerAccounts/:id',
                name: 'CustomerManagementCustomerAccountDetail',
                component: CustomerManagementCustomerAccountDetail
            },

            {
                path: '/accountManagements/bankAccounts',
                name: 'AccountManagementBankAccountManager',
                component: AccountManagementBankAccountManager
            },
            {
                path: '/accountManagements/bankAccounts/:id',
                name: 'AccountManagementBankAccountDetail',
                component: AccountManagementBankAccountDetail
            },



    ]
})
