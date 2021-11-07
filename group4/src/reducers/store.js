import { createStore, combineReducers } from "redux";
import userReducer from "../Components/Users/reducer";
import productsReducer from '../reducers/products/reducer'
import cartReducer from "../reducers/cart/reducer";
const reducers = combineReducers({ userReducer ,  productsReducer,cartReducer});
const store = createStore(reducers);

export default store;
