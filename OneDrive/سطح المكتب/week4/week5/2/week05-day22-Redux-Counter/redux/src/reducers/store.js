import { createStore, combineReducers } from "redux";
import count from "./user/Count";
           // name redux Count//object {}
const reducers = combineReducers({count});
//start from here
const store = createStore(reducers);

export default store;
