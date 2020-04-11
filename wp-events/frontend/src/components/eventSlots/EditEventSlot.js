import React, {useState} from "react";
import {useParams, useHistory} from "react-router-dom";
import {useSelector, useDispatch} from "react-redux";
import EventSlotForm from "./EventSlotForm";
import {editEventSlot} from "../../actions/eventSlotsActions";

function EditEventSlot(props) {
    const dispatch = useDispatch();
    const params = useParams();
    const history = useHistory();
    const {eventSlots} = useSelector(state => state.eventSlots);

    const curEventSlot = eventSlots.find(es => es.slotId === params.slotId) || {};
    const [eventSlot, setEventSlot] = useState({
        slotId:curEventSlot.slotId || "",
        event: curEventSlot.event || "",
        musicBand: curEventSlot.musicBand || "",
        coffeeBar: curEventSlot.coffeeBar || "",
        fromTime:curEventSlot.fromTime || "",
        toTime:curEventSlot.toTime || "",
        date:curEventSlot.date || ""
    });
    const onChange = e => {
        e.persist();
        setEventSlot(s => ({...s, [e.target.name]: e.target.value}));
    };
    const onSubmit = e => {
        e.preventDefault();
        dispatch(editEventSlot(eventSlot, history));
    };
    const onReset = () => {
        setEventSlot(s => ({
            event: "",
            musicBand: "",
            coffeeBar: "",
            fromTime:"",
            toTime:"",
            date:""}));
    };
    return (
        <EventSlotForm
            heading="Edit"
            onChange={onChange}
            onSubmit={onSubmit}
            onReset={onReset}
            event={eventSlot.event}
            musicBand={eventSlot.musicBand}
            coffeeBar={eventSlot.coffeeBar}
            date={eventSlot.date}
            fromTime={eventSlot.fromTime}
            toTime={eventSlot.toTime}
        />
    );
}

export default EditEventSlot;