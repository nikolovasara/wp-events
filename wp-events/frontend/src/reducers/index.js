import coffeeBars from "./coffeeBarsReducer";
import events from "./eventsReducer";
import eventSlots from "./eventSlotsReducer";
import {combineReducers} from "redux";

export default combineReducers({coffeeBars,events,eventSlots});