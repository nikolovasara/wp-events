import {SET_EVENTS} from "../actions/types";

const initialState = {
  eventsForCoffeeBar: []
};

export default (state = initialState, action) => {
    switch (action.type) {
        case SET_EVENTS:
            return {
                ...state,
                eventsForCoffeeBar: [...action.payload]
            };
        default:
            return state;
    }
};