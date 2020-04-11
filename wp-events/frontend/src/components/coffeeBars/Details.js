import React, {useEffect} from "react";
import {useSelector, useDispatch} from "react-redux";
import {useParams} from "react-router";
import {getEventsForCoffeeBar} from "../../actions/eventsActions";

const EventItem = ({event}) => {
    return <li>{event.name}</li>;
};

function Details(props) {
    const {coffeeBars} = useSelector(state => state.coffeeBars);
    const {eventsForCoffeeBar} = useSelector(state => state.events);
    console.log("Event", eventsForCoffeeBar);
    const dispatch = useDispatch();
    const params = useParams();
    const curCoffeeBar = coffeeBars.find(cb => cb.id === params.coffeeBarId) || {};

    useEffect(() => {
        dispatch(getEventsForCoffeeBar(curCoffeeBar.id));
    }, [dispatch, curCoffeeBar]);
    const eventsList = eventsForCoffeeBar.map(event => (
        <EventItem key={event.id} event={event}/>
    ));
    return (
        <div className="row w-75 mx-auto mt-5">
         <div className="card text-white bg-dark  pl-4 mb-3 py-4">
            <h4 className="text-upper text-left ">Coffee Bar details</h4>
            <div className="form-group row p-2">
                <label
                    htmlFor="coffeeBar"
                    className="col-m-4 offset-sm-1 text-right"
                >
                    Coffee Bar name
                </label>
                <div className="col-sm-6">
                    <input
                        readOnly={true}
                        value={curCoffeeBar.name}
                        name="name"
                        type="text"
                        className="form-control"
                        id="coffeeBar"
                        placeholder="Coffee Bar name"
                    />
                </div>
            </div>
            <div className="form-group row">
                <label htmlFor="city" className="col-sm-4 offset-sm-1 text-right">
                    City
                </label>
                <div className="col-sm-6">
                    <input
                        readOnly={true}
                        value={curCoffeeBar.city}
                        name="city"
                        type="text"
                        className="form-control"
                        id="city"
                        placeholder="city"
                    />
                </div>
            </div>
        </div>
        <div className="card bg-light bg-secondary mb-3 p-4">
            <h5>Events for {curCoffeeBar.name}</h5>
            <ul className="list">{eventsList}</ul>
        </div>
    </div>
);
}

export default Details;