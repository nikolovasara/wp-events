import React, {useState} from "react";
import {useDispatch} from "react-redux";
import {useHistory} from "react-router";
import EventSlotForm from "./EventSlotForm";
import {newEventSlot} from "../../actions/eventSlotsActions";

function NewEventSlot(props) {
    const dispatch = useDispatch();
    const history = useHistory();
    const [eventSlot, setEventSlot] = useState({
        eventId: 3,
        musicBandId: "Filch",
        coffeeBarId: "1",
        fromTime:"",
        toTime:"",
        date: ""
    });

    const onChange = e => {
        e.persist();
        setEventSlot(s=>({...s,[e.target.name]: e.target.value}));
    };
    const onSubmit = e => {
        e.preventDefault();
        dispatch(newEventSlot(eventSlot,history));
    };
    const onReset = () => {
        setEventSlot(s => ({
            eventId: 3,
            musicBandId: "Filch",
            coffeeBarId: 1,
            fromTime: "",
            toTime: "",
            date: ""}));
    };


    return (
        <EventSlotForm
            heading="New"
            onChange={onChange}
            onSubmit={onSubmit}
            onReset={onReset}
            event={"Memorable Night with Your Friends"}
            musicBand={"Filch"}
            coffeeBar={"Gallery"}
            date={eventSlot.date}
            fromTime={eventSlot.fromTime}
            toTime={eventSlot.toTime}
        />
    );
}
export default NewEventSlot;