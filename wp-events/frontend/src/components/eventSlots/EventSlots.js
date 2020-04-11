import React, {useEffect} from "react";
import Moment from "react-moment";
import {useSelector, useDispatch} from "react-redux";
import {useHistory} from "react-router-dom";
import {removeEventSlot, getEventSlots} from "../../actions/eventSlotsActions";
import isEmpty from "lodash.isempty"

function EventSlotsTable({eventSlots, ...rest}) {
    const eventSlotsList = eventSlots.map((eventSlot) => {
        return (
            <EventSlotItem
                key={eventSlot.slotId}
                eventSlot={eventSlot}
                event={eventSlot.event}
                musicBand={eventSlot.musicBand}
                coffeeBar={eventSlot.coffeeBar}
                onEdit={rest.onEdit}
                onRemove={rest.onRemove}
            />
        );
    });
    return (
        <div>
            <div className={"row"}>
                {eventSlotsList}
            </div>
        </div>

    );
}


function EventSlotItem({eventSlot, ...rest}) {
    return (
        <div className="card col-8 mx-auto my-4 px-5 pb-5 cardEventSlot" style={{fontSize:"17px"}}>
                <div className="card-header mb-3" style={{height:"75px",fontSize:"20px"}}>
                    <div className="row">
                        <div className="col-md-6 px-3 pt-2 text-white">
                            {eventSlot.event.name}
                        </div>
                        <div className="col-md-6 text-right pt-2">

                            <button
                                onClick={() => rest.onRemove(eventSlot.slotId)}
                                className="btn btn-sm btn-outline-secondary btn-outline-light"
                            >
                                <span className="fa fa-trash"/>

                            </button>

                        </div>

                    </div>
                </div>
                <div className="row pl-2">
                    <div className="col-md-6 font-weight-bold">Music Band:</div>
                    <div className="col-md-6">
                        <span>{eventSlot.musicBand.name}</span>
                    </div>
                </div>
            <hr/>
                <div className="row pl-2">
                    <div className="col-md-6 font-weight-bold">Coffee Bar:</div>
                    <div className="col-md-6">
                        <span>{eventSlot.coffeeBar.name}</span>
                    </div>
                </div>
            <hr/>
                <div>
                    <div className="row pl-2">
                        <div className="col-md-6 font-weight-bold"  style={{width:"454px"}}>Date:</div>
                        <div className="col-md-6" ><Moment
                            format="DD.MM.YYYY">{eventSlot.date}</Moment></div>
                    </div>

                </div>
            <hr/>
                <div className="row pl-2">
                    <div className="col-md-6 font-weight-bold">Time:</div>
                    <div className="col-md-6">
                        <Moment format={"HH:mm"} parse={"HH:mm:ss"}>
                            {eventSlot.fromTime}
                        </Moment>-
                        <Moment parse={"HH:mm:ss"} format={"HH:mm"}>
                            {eventSlot.toTime}
                        </Moment>
                    </div>
                </div>
        </div>

    );
}




function EventSlots(props) {
    const dispatch = useDispatch();
    const history = useHistory();
    const {eventSlots} = useSelector(state => state.eventSlots);

    useEffect(() => {
        dispatch(getEventSlots());
    }, [dispatch]);

    const onRemove = slotId => {
        dispatch(removeEventSlot(slotId, history));
        history.push(`/events/delete`);
    };
    const onNewEventSlot = () => {
        history.push("/events/new");
    };
    console.log(eventSlots);
    const eventSlotsTable = !isEmpty(eventSlots) ? (
        <EventSlotsTable
            eventSlots={eventSlots}
            onRemove={onRemove}
            onNewEventSlot={onNewEventSlot}
        />
    ) : (
        <p className="container m-auto text-danger text-sm-center p-3">No Event Slots</p>
    );
    return (
        <div className="row">
           {eventSlotsTable}
        </div>
    );
}

export default EventSlots;