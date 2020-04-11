import React from "react";
import { useHistory } from "react-router-dom";

function EventSlotForm(props){
    const history=useHistory();

    const validateForm= () => {
        return true;
    };
    return (
        <div className="container w-75 mx-auto mt-5">
            <form onSubmit={props.onSubmit} className="card w-50">
                <h5 className="h-75 text-upper text-left px-3 card-header">{props.heading} Event</h5>
                <div className="form-group row pt-3">
                    <label
                        htmlFor="event"
                        className="col-sm-4 offset-sm-1 text-left"
                    >
                        Event name:
                    </label>
                    <div className="col-sm-6">
                        <input
                            onChange={props.onChange}
                            value={props.event || ""}
                            name="event"
                            type="text"
                            className="form-control"
                            id="event"
                            placeholder="event name"
                            disabled={true}
                        />
                    </div>
                </div>
                <div className="form-group row">
                    <label htmlFor="musicBand" className="col-sm-4 offset-sm-1 text-left">
                        Music Band:
                    </label>
                    <div className="col-sm-6">
                        <input
                            onChange={props.onChange}
                            value={props.musicBand || ""}
                            name="musicBand"
                            type="text"
                            className="form-control"
                            id="musicBand"
                            placeholder="music band"
                        />
                    </div>
                </div>
                <div className="form-group row">
                    <label htmlFor="coffeeBar" className="col-sm-4 offset-sm-1 text-left">
                        Coffee Bar:
                    </label>
                    <div className="col-sm-6">
                        <input
                            onChange={props.onChange}
                            value={props.coffeeBar || ""}
                            name="coffeeBar"
                            type="text"
                            className="form-control"
                            id="coffeeBar"
                            placeholder="coffee bar"
                            disabled={true}
                        />
                    </div>
                </div>
                <div className="row form-group pl-2">
                    <div className="col-md-6">
                        <div className="d-flex flex-row justify-content-start">
                            <label htmlFor="fromTime" className="col-sm-4 offset-sm-1 text-left">
                                 &nbsp;Starts:
                            </label>
                            <div className="col-md-5">
                                <input name={"fromTime"} type="text"
                                       onChange={props.onChange}
                                       value={props.fromTime || ""}
                                       className="form-control"
                                       pattern="[0-2]{1}[0-9]{1}:[0-5]{1}[0-9]{1}"
                                       title="from"/>
                            </div>
                            <div className="col-md-2 text-center">
                                -
                            </div>
                            <label htmlFor="toTime" className="col-sm-4 offset-sm-1 text-left">
                                Ends:
                            </label>
                            <div className="col-md-5 text-right">
                                <input name={"toTime"} type="text"
                                       onChange={props.onChange}
                                       value={props.toTime || ""}
                                       pattern="[0-2]{1}[0-9]{1}:[0-5]{1}[0-9]{1}"
                                       className="form-control"
                                       title="to"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="row form-group">
                    <label htmlFor="date" className="col-sm-4 offset-sm-1 text-left">
                        Date:
                    </label>
                    <div className="col-md-6">
                        <div className="row">
                            <div className="col-md-5">
                                <input name={"date"} type="text"
                                       onChange={props.onChange}
                                       value={props.date || ""}
                                       className="form-control"
                                       pattern="(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}"
                                       title="date"/>
                            </div>
                        </div>
                    </div>
                </div>


                <div className="form-group row pt-3">
                    <div className="offset-sm-1 col-sm-3  text-center">
                        <button
                            disabled={!validateForm()}
                            type="submit"
                            className="btn btn-primary text-upper"
                        >
                            Save
                        </button>
                    </div>
                    <div className="offset-sm-1 col-sm-3  text-center">
                        <button
                            onClick={props.onReset}
                            className="btn btn-warning text-upper"
                        >
                            Reset
                        </button>
                    </div>
                    <div className="offset-sm-1 col-sm-3  text-center">
                        <button
                            onClick={() => history.push("/events")}
                            className="btn btn-danger text-upper"
                        >
                            Cancel
                        </button>
                    </div>
                </div>
            </form>
        </div>
    );
}

export default EventSlotForm;