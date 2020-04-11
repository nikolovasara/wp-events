import axios from 'axios';
import {SET_EVENT_SLOTS, SET_RESPONSE_MESSAGE} from "./types";


export const getEventSlots = () => async dispatch => {
    try{
        console.log("Should get all event slots");
        const eventSlots=await axios.get(`/events`);
        console.log(eventSlots.data);
        dispatch({ type: SET_EVENT_SLOTS, payload: eventSlots.data});
    } catch (e) {
        console.log(e);
    }
};

export const removeEventSlot = (slotId, history) => async dispatch => {
    try{
        console.log("Remove event slot with id ", slotId);
        const responseMessage=await axios.delete(`/events/${slotId}`);
        dispatch({ type: SET_RESPONSE_MESSAGE, payload: responseMessage.data});
        history.push("/events");
    }
    catch (e) {
        console.log(e);
    }
};

export const editEventSlot = (eventSlot, history) => async dispatch =>{
    try{
        console.log("Edit event slot data ", eventSlot);
        const responseMessage=await axios.patch(
            `/events/${eventSlot.slotId}`,
            null,
            {
                params:{
                    eventId: eventSlot.eventId,
                    musicBand: eventSlot.musicBand,
                    coffeeBar: eventSlot.coffeeBar,
                    fromTime:eventSlot.fromTime,
                    toTime:eventSlot.toTime,
                    date:eventSlot.date

                }
            }
        );
        dispatch({ type: SET_RESPONSE_MESSAGE, payload: responseMessage.data });
        history && history.push("/events");
    }
    catch (e) {
        console.log(e);
    }
};

export const newEventSlot = (eventSlot, history) =>async dispatch => {
    try{
        console.log("New event slot ", eventSlot);
        const responseMessage = await axios.post(`/events/`, null, {
            params: {
                eventId:3,
                musicBand: "Filch",
                coffeeBar: 1,
                fromTime:eventSlot.fromTime,
                toTime:eventSlot.toTime,
                date:eventSlot.date
            }
        });
        dispatch({ type: SET_RESPONSE_MESSAGE, payload: responseMessage.data });
        history && history.push("/events");
    }
    catch (e) {
        console.log(e);
    }
};