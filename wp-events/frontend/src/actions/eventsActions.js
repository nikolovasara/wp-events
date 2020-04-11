import {SET_EVENTS} from "./types";
import axios from "axios";

export const getEventsForCoffeeBar = id => async dispatch =>{
    try{
        const {data}=await axios.get(`/coffeeBars/${id}/events`);
        console.log(data);
        dispatch({type:SET_EVENTS, payload: data || []});
    }
    catch (e) {
        console.log(e);
    }
};