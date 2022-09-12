import {
    CREATE_DRUGS,
    RETRIEVE_DRUGS,
    UPDATE_DRUGS,
    DELETE_DRUGS
    
  } from "./types";
//   import TutorialDataService from "../services/tutorial.service";
import drugsDataService from "../services/drugsData.service";
  export const createDrugs = (drugName, drugPrice,drugQuantity,expiryDate) => async (dispatch) => {
    try {
      const res = await drugsDataService.create({ drugName, drugPrice,drugQuantity,expiryDate});
      dispatch({
        type: CREATE_DRUGS,
        payload: res.data,
      });
      return Promise.resolve(res.data);
    } catch (err) {
      return Promise.reject(err);
    }
  };
  export const retrieveDrugs = () => async (dispatch) => {
    try {
      const res = await drugsDataService.getAll();
      dispatch({
        type: RETRIEVE_DRUGS,
        payload: res.data,
      });
    } catch (err) {
      console.log(err);
    }
  };
  export const updateDrugs = (id, data) => async (dispatch) => {
    try {
      const res = await drugsDataService.update(id, data);
      dispatch({
        type: UPDATE_DRUGS,
        payload: data,
      });
      return Promise.resolve(res.data);
    } catch (err) {
      return Promise.reject(err);
    }
  };
  export const deleteDrugs= (id) => async (dispatch) => {
    try {
      await drugsDataService.delete(id);
      dispatch({
        type: DELETE_DRUGS,
        payload: { id },
      });
    } catch (err) {
      console.log(err);
    }
  };
//   export const deleteAllTutorials = () => async (dispatch) => {
//     try {
//       const res = await TutorialDataService.deleteAll();
//       dispatch({
//         type: DELETE_ALL_TUTORIALS,
//         payload: res.data,
//       });
//       return Promise.resolve(res.data);
//     } catch (err) {
//       return Promise.reject(err);
//     }
//   };
  export const findByTitle = (drugName) => async (dispatch) => {
    try {
      const res = await drugsDataService.findByTitle(drugName);
      dispatch({
        type: RETRIEVE_DRUGS,
        payload: res.data,
      });
    } catch (err) {
      console.log(err);
    }
  };