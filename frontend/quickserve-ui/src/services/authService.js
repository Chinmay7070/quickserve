import axios from 'axios'
import { data } from 'react-router-dom'

const BASE_URL = 'http://localhost:8085/auth'

const authService = {
    register : (data) =>{
        return axios.post('${BASE_URL}/register',data)
    },
    verifyOtp: (data) =>{
        return axios.post('${BASE_URL}/verify-otp',data)
    },
    resendOtp: (data) => {
    return axios.post(`${BASE_URL}/resend-otp`, data)
  },

  login: (data) => {
    return axios.post(`${BASE_URL}/login`, data)
  },

  forgotPassword: (data) => {
    return axios.post(`${BASE_URL}/forgot-password`, data)
  },

  verifyForgotOtp: (data) => {
    return axios.post(`${BASE_URL}/verify-forgot-otp`, data)
  },

  resetPassword: (data) => {
    return axios.post(`${BASE_URL}/reset-password`, data)
  },

  getProfile: (token) =>{
    return axios.get('${BASE_URL}/profile',{
        headers:{
            Authorization: 'Bearer ${token}'
        }
    })
  }

}
export default authService