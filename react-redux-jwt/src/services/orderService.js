import axios from 'axios';

//const DRUG_API_BASE_URL = "http://localhost:8082/";
const ORDER_API_BASE_URL_1 = "http://localhost:8086/";
/*const headers = {
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Headers": "*",
    "Access-Control-Allow-Credentials": true,
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  }*/

class OrderService {    

    
    getAllOrders(){
        return axios.get(ORDER_API_BASE_URL_1 + 'order/');
    }
    saveOrder(order){
        return axios.post(ORDER_API_BASE_URL_1 + 'order/save', order);
    }
    deleteOrder(orderId){
        return axios.delete(ORDER_API_BASE_URL_1 + 'order/delete/' + orderId);
    }
    getOrderbyId(id){
        return axios.get(ORDER_API_BASE_URL_1 + 'order/'+id);
    }
    
    /*getAllDrugs(){
        return axios.get(DRUG_API_BASE_URL + 'doctors/drugs/all');
    }*/
    /*saveDrugs(drugs){
        return axios.post(DRUG_API_BASE_URL + 'admin/drugs/save', drugs, { headers });
    }*/

    /*getDrugById(drugId){
        return axios.get(DRUG_API_BASE_URL + 'admin/drugs/' + drugId);
    }
    getDrugById(drugId){
        return axios.get(ORDER_API_BASE_URL_1 + 'drugs/' + drugId);
    }*/
    
    /*getDrugByName(drugName){
        return axios.get(ORDER_API_BASE_URL_1 + 'drugs/drugsname/' + drugName);
    }

    /*updateDrugs(drugs, drugId){
        return axios.put(DRUG_API_BASE_URL + 'admin/drugs/update/' + drugId, drugs, { headers });
    }
    updateDrugs(drugs, drugId){
        return axios.put(ORDER_API_BASE_URL_1 + 'drugs/update/' + drugId, drugs);
    }

    /*deleteDrugs(drugId){
        return axios.delete(DRUG_API_BASE_URL + 'admin/delete/' + drugId);
    }
    deleteDrugs(drugId){
        return axios.delete(ORDER_API_BASE_URL_1 + 'drugs/delete/' + drugId);
    }*/
}

export default new OrderService()