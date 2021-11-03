const initialState = {
  counter:0,
};
// name redux   state -actio paylod mean execute on the value value here is counter is 1
const count = (state = initialState, { type, payload }) => {
  switch (type) {
    case "INCREMENT":
      return {
        // counter:payload 
      counter:state.counter+1

      };

     case "DECREMENT":
      return {
        // counter:payload
      counter:state.counter-1

      };
      case "REST":
        return {
          // counter:payload
      counter:0
  
        };

    default:
      return state;
  }
};

export default count;

export const increment = () => {
  return {
    type:"INCREMENT" ,
   
  
  };
};
export const decrement = () => {
  return {
    type:"DECREMENT" ,
  
  
  };
};
export const reset = () => {
  return {
    type:"REST" ,

  };
};


