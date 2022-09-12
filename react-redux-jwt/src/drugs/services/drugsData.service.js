import http from "../http-common";
class DrugsDataService {
  getAll() {
    return http.get("doctors/drugs/all");
  }
 
  create(data) {
    return http.post("admin/drugs/save", data);
  }
  update(id, data) {
    return http.put(`admin/drugs/update/${id}`, data);
  }
  delete(id) {
    return http.delete(`admin/delete/${id}`);
  }
  
  
  findByTitle(drugsName) {
    return http.get(`drugs?{drugsname}=${drugsName}`);
  }
}
export default new DrugsDataService();