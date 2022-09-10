import axios from 'axios';

const SIGNUP_API_BASE_URL = "http://localhost:8082/signup/doctorsData";
class signupservice{

  createDoctors(doctorsData){
        return axios.post(SIGNUP_API_BASE_URL,doctorsData);
    }
}
export default new signupservice()