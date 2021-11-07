const initialState = {
  products: { productsLis: [] },//{id,title,desc,price,image}
  cartItems: [], //{id,title,desc,price,image,qty}
  currentItem: null
}

const cartReducer = (state = initialState, action) => {
  // const  cartReducer  = (state = initialState, { type, payload }) => {

  switch (action.type) {
    case "ADD_TO_CART":
      //Get the item's data from products array
      console.log('state products ', state.products)
      const item = state.products.find(product => product.id === action.payload.id)
      const inCart = state.cartItems.find(item => item.id === action.payload.id ? true : false)
      console.log('item found is ', item)
      return {
        ...state,
        cartItems: inCart ? state.cartItems.map((item) => item.id === action.payload.id ? { ...item, qty: item.qty + 1 } : item)
          : [...state.cartItems, { ...item, qty: 1 }]
      };

    case "REMOVE_FROM_CART":
      return {
        ...state,
        cartItems: state.cartItems.filter(item => item.id !== action.payload.id)
      };
    case "LOAD_CURRENT_ITEM":
      return {
        ...state,
        cartItems: state.cartItems.map(item.id === action.payload.id ? { ...item, qty: action.payload.qty } : item)
      };

    case "ADJUST_QTY":

      let itemFound = state.cartItems.find(item => item.id == action.payload.id)
      console.log('item found ===> ', action.payload.qty)

      action.payload.qty ? itemFound.qty += 1
        : action.payload.qty === 0 ? itemFound.qty = 0
          : itemFound.qty -= 1
      let arr = []

      state.cartItems.map(
        item => item.id != itemFound.id ? arr.push(item)
          : itemFound.qty != 0 ? arr.push(itemFound)
            : null
      )

      return {
        ...state,
        cartItems: arr
      };



    case "CLEAR_CART":
      return { ...state, cartItems: [] }

    default:
      return state;
  }

}

export default cartReducer