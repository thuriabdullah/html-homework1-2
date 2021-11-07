import React , { useState, useEffect} from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { adjustQty,clearCart} from '../reducers/cart/actions'

function Cart() {

    const dispatch = useDispatch()
    const coupons = {
        '123':5,
        '234':10,
        '345':15
    }

    const collectionDelivery = {
        'Aramex': 23,
        'UPS': 8,
        'DHL': 5,
        'SMSA': 12, 
   }
   
    
    const collectionDeliveryOptions = {
         'Premium': 12,
         'Medium': 8,
         'Basic': 5
    }

    

    const cartItems = useSelector(state => state.cartItems)
    const [input,setInput] = useState('')
    const [total,setTotal] = useState(0)
    const [couponDiscount,setCouponDiscount] = useState(0)
    const [collection,setCollection] = useState('Aramex')
    const [option,setOption] = useState('Basic')

    useEffect(() => {
            let items = 0;
            let price = 0;
            cartItems.forEach(item => {
                price += item.qty * item.price
            })
            setTotal(price)
        
    }, [cartItems])


    function checkCoupon(code){
        console.log('checking copon',code)
        var discount  
        coupons[code] ? discount =  setCouponDiscount(coupons[code])
                    : discount =  window.alert('Cant find a coupon with this code ,please try with another one')
      return discount
    }


    return (
        <div className="cart w-100">

            {cartItems && cartItems.length > 0 ? 
                cartItems.map(item => (
                    <div className="cart-item d-flex " key={item.id}>
                        <div className="cart-item-left d-flex flex-row">
                            <img src={item.image} alt="" />
                        </div>
                        <div className="cart-item-middle d-flex ">
                            <h6>{item.title}</h6>
                            <h5 >${item.price}</h5>
                                <div className="quantity">
                                <button 
                                    className="btn btn-secondary" 
                                    onClick={ () => dispatch(adjustQty({id :item.id, qty:true}))} 
                                >+</button>
                                <span className="px-2 mx-2">{item.qty}</span>
                                <button 
                                    className="btn btn-secondary"
                                    onClick={ () => dispatch(adjustQty({id :item.id, qty:false}))} 
                                >-</button></div>
                        </div>
                        <div className="cart-item-right d-flex ">
                            <h5>Total : ${item.qty * item.price}</h5>
                            <button 
                                className="btn btn-danger m-2"
                                onClick={ () => dispatch(adjustQty({id :item.id, qty:0}))} 
                            >Delete</button>
                        </div>
                        
                    </div>
                ))
                : <h3 className="text-center my-3">You haven't any items in the cart</h3>}

            <h4 className="text-center">Total : ${total.toString()}</h4>
           
           { cartItems && cartItems.length > 0 &&
           <>
            <div className="cart__coupon w-80 m-2">
                <h4>Enter a coupon code</h4>
                <input  placeHolder='Coupon code' className="p-1 m-1 mt-3" type="text"  value={input} onChange={(e) => setInput(e.target.value)} />
                <div className="btn btn-secondary" onClick={() => checkCoupon(input)} >Confirm</div>
                {couponDiscount !== 0 && <div>{couponDiscount}% discount</div>}
            </div>
            <div className="cart__delivery d-flex flex-row">
                <div className="cart__delivery__collection m-4 d-flex flex-row">
                    <h4 className="m-2" >Collection-Delivery</h4>    
                    <select value={collection} onChange={(e) => setCollection(e.target.value)} id="cars">
                        <option value="Aramex">Aramex</option>
                        <option value="UPS">UPS</option>
                        <option value="DHL">DHL</option>
                        <option value="SMSA">SMSA</option>
                    </select>
                </div>

                <div className="cart__delivery__options m-4 d-flex flex-row ">
                    <h4 className="m-2">Delivery Option</h4>    
                    <select value={option} onChange={(e) =>{console.log(e.target.value)  ;return setOption(e.target.value)}} id="cars">
                        <option value="Premium">Premium ${collectionDelivery[collection] + 12} </option>
                        <option value="Medium">Medium ${collectionDelivery[collection] + 8} </option>
                        <option value="Basic">Basic ${collectionDelivery[collection] + 5} </option>
                    </select>
                </div>
                    {console.log(total * (couponDiscount/100) + collectionDelivery[collection] + collectionDeliveryOptions[option])}
               
                
            </div>
            <div className="cart__check d-flex flex-column">
            {collection && 
             <h4 className="text-center">
                       Total price(with delivery and coupons): ${ total - total.toFixed(2) * (couponDiscount/100) + collectionDelivery[collection] + collectionDeliveryOptions[option]}
            </h4>}
            <div className="btn btn-primary mx-auto text-center w-50 m-4" onClick={() => {
                alert('Your order is done succesfully , thanks for trusting us');
                dispatch(clearCart())
            }}>
                Confirm
            </div>
            </div>
            </>
            }
        </div>
    )
}

export default Cart
