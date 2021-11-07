import '../App.css';
import Wish_List1 from "../Img/Wish_List1.png"
import Wish_List2 from "../Img/Wish_List2.png"
import { useNavigate } from 'react-router-dom';

function Element(props) {
  const navigate = useNavigate();


  return (
    <div>

    
<div className="card card_e">
          <img className="card-img-top" src={props.props.image} alt="Card image cap card_e" height="150px"/>
          <div className="card-body position-relative">
            <h6 className="card-title title">{props.props.title}</h6>
            <p className="position-absolute bottom-0 end-0 card_price">{props.props.price}$</p>

           <img className="position-absolute bottom-0 start-0 card_img" id={props.props.id} src={Wish_List1} alt="Wish list" onClick={()=>{
              if(document.getElementById(props.props.id).src.includes("Jggg") ){document.getElementById(props.props.id).src = Wish_List1}
              else{document.getElementById(props.props.id).src = Wish_List2}
            }} />
          </div>
          <div className="card-footer bo0" id="text1">
            <small className="text-muted" >

            <button type="button" className="btn btn-outline-secondary btn-sm card_btn" onClick={()=>{
            navigate("/Details/"+props.props.id);
            }}>Details</button>
            <button type="button" className="btn btn-outline-success btn-sm card_btn">Add to cart</button>
            {/* <Link to="/" onClick={() => dispatch(addToCart(product.id))} className="btn btn-primary">Add to cart</Link> */}

            </small>
          </div>
        </div>
  
    </div>
  );
}

export default Element;
