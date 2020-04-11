import {SET_EVENT_SLOTS} from "../actions/types";

const initialState ={
    eventSlots: []
};

export default (state = initialState, action) => {
    switch (action.type) {
        case SET_EVENT_SLOTS:
            return {
                ...state,
                eventSlots: action.payload
            };
        default:
            return state;
    }
};