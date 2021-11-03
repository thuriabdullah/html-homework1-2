import "./App.css";

import { useDispatch, useSelector } from "react-redux";
import { increment,decrement,reset } from "./reducers/user/Count";
import { useState } from "react";

function App() {
 
  // const [counter, setCounter] = useState(0);

  const dispatch = useDispatch();

  const state = useSelector((state) => {
    console.log(state)
    return {
      counter: state.count.counter,
    };
  });


  const incre = () => {
    
    const action = increment(1);

    

    dispatch(action);
  };
   const decre = () => {

    const action = decrement(1);

    

    dispatch(action); 
   }
   const rrest = () => {

    const action = reset();

    

    dispatch(action); 
   }
  return (
    <div className="App">
      
      <p>{state.counter}</p>
      <button onClick={incre}>increment</button>
      <button onClick={ decre}>decrement</button>
      <button onClick={ rrest}>reset</button>

      
    </div>
  );
}

export default App;
