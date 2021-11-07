const initialState= {
    users:[],
}

const userReducer= (state=initialState , {type,payload})=>{
    switch (type) {
        case "addUser":
            return {
                users: payload,
            }
    
        default:
            return state;
    }

}

export default userReducer;