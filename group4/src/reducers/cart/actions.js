
export const addToCart = (itemID) => {
  console.log('adding to cart' , itemID)
  return {
      type: "ADD_TO_CART",
      payload: {
          id: itemID,
      }
  }
}

export const removeFromCart = (itemID) => {
  return {
      type: "REMOVE_FROM_CART",
      payload: {
          id: itemID,
      }
  }
}

export const adjustQty = ({id, qty}) => {
  return {
      type: "ADJUST_QTY",
      payload: {
          id,
          qty
      }
  }
}

export const loadCurrentItem = (item) => {
  return {
      type: "LOAD_CURRENT_ITEM",
      payload: item
  }
}




export const selectedProduct = (product) => {
  return {
      type: "SELECTED_PRODUCT",
      payload: product,
  }
}

export const clearCart = () => {
  return {
    type:"CLEAR_CART"
  }
}