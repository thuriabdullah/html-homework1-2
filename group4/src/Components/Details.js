import '../App.css';
import { useSelector } from "react-redux";
import {useParams, useNavigate} from "react-router-dom";


function Details(props) {

  const navigate = useNavigate();


  let { id } = useParams();
  const state = useSelector((state) => {
    return { products: state.productsReducer };});


  return (
    <div className="Details position-relative">

<div className="card text-center position-absolute top-50 start-50 translate-middle card_d">
  <div className="card-header">
  <h5>Description</h5>
  </div>
  <div className="card-body">
  

  {   state.products.productsLis === undefined ? '' : 
      state.products.productsLis.map((element, index) => {
        if(element.id === Number(id)){
        return <p className="card-text" key={index}>{element.description}kkkk</p> }
        // <button className="btn btn-primary">Add to Cart</button>
        
        })}


    
  </div>
  <div className="card-footer text-muted">
  <a  className="btn btn-outline-secondary Details_btn" onClick={()=>{
    navigate(-1);
  }}>Go Back</a>
  </div>
</div>

</div>
    
  );
}

export default Details;
