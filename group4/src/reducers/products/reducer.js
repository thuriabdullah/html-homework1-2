const initialState = {
  products: {productsLis: [] }
}

const productsReducer = (state = initialState, { type, payload }) => {
  switch (type) {

    case "SET_LIST":
      return {
        productsLis: payload
      };
      
    default:
      return state;
  }
};

export default productsReducer;
