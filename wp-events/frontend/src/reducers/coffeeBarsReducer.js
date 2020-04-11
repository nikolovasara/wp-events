import {SET_COFFEE_BARS} from "../actions/types";

const initialState ={
    coffeeBars: []
};

export default (state = initialState, action) => {
    switch (action.type) {
        case SET_COFFEE_BARS:
            return {
                ...state,
                coffeeBars: action.payload
            };
        default:
            return state;
    }
};