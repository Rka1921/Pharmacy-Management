import axios from 'axios';

//const DRUG_API_BASE_URL = "http://localhost:8082/";
const DRUG_API_BASE_URL_1 = "http://localhost:8081/api/";
/*const headers = {
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Headers": "*",
    "Access-Control-Allow-Credentials": true,
    "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
  }*/

class DrugService {

    

    /*getAllDrugs(){
        return axios.get(DRUG_API_BASE_URL + 'doctors/drugs/all');
    }*/
    getAllDrugs(){
        return axios.get(DRUG_API_BASE_URL_1 + 'drugs');
    }

    saveDrugs(drugs){
        return axios.post(DRUG_API_BASE_URL_1 + 'drugs/save', drugs);
    }
    /*saveDrugs(drugs){
        return axios.post(DRUG_API_BASE_URL + 'admin/drugs/save', drugs, { headers });
    }*/

    /*getDrugById(drugId){
        return axios.get(DRUG_API_BASE_URL + 'admin/drugs/' + drugId);
    }*/
    getDrugById(drugId){
        return axios.get(DRUG_API_BASE_URL_1 + 'drugs/' + drugId);
    }
    getDrugByName(drugName){
        return axios.get(DRUG_API_BASE_URL_1 + 'drugs/drugsname/' + drugName);
    }

    /*updateDrugs(drugs, drugId){
        return axios.put(DRUG_API_BASE_URL + 'admin/drugs/update/' + drugId, drugs, { headers });
    }*/
    updateDrugs(drugs, drugId){
        return axios.put(DRUG_API_BASE_URL_1 + 'drugs/update/' + drugId, drugs);
    }

    /*deleteDrugs(drugId){
        return axios.delete(DRUG_API_BASE_URL + 'admin/delete/' + drugId);
    }*/
    deleteDrugs(drugId){
        return axios.delete(DRUG_API_BASE_URL_1 + 'drugs/delete/' + drugId);
    }
}

export default new DrugService()