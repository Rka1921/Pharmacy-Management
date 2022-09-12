import {
    CREATE_DRUGS,
    RETRIEVE_DRUGS,
    UPDATE_DRUGS,
    DELETE_DRUGS
    
  } from "./types";
  const initialState = [];
  function drugReducer(drugsData = initialState, action) {
    const { type, payload } = action;
    switch (type) {
      case CREATE_DRUGS:
        return [...drugsData, payload];
      case RETRIEVE_DRUGS:
        return payload;
      case UPDATE_DRUGS:
        return drugsData.map((drug) => {
          if (drug.id === payload.id) {
            return {
              ...drug,
              ...payload,
            };
          } else {
            return drug;
          }
        });
      case DELETE_DRUGS:
        return drugsData.filter(({ id }) => id !== payload.id);
      
      default:
        return drugsData;
    }
  };
  export default  drugReducer ;