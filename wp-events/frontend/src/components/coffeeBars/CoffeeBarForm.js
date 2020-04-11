import React from "react";
import { useHistory } from "react-router-dom";

function CoffeeBarForm(props){
    const history=useHistory();
    const {name}=props;

    const validateForm= () => {
        if(!name){
            return true;
        }else return false;
    };
    return (
        <div className="container w-75 mx-auto mt-5">
            <form onSubmit={props.onSubmit} className="card w-50">
                <h5 className="h-75 text-upper text-left px-3 card-header">{props.heading} Coffee Bar</h5>
                <div className="form-group row pt-3">
                    <label
                        htmlFor="coffeeBar"
                        className="col-sm-4 offset-sm-1 text-left"
                    >
                        CoffeeBar name
                    </label>
                    <div className="col-sm-6">
                        <input
                            onChange={props.onChange}
                            value={props.name}
                            name="name"
                            type="text"
                            className="form-control"
                            id="coffeeBar"
                            placeholder="coffee bar name"
                        />
                    </div>
                </div>
                <div className="form-group row">
                    <label htmlFor="city" className="col-sm-4 offset-sm-1 text-left">
                        City
                    </label>
                    <div className="col-sm-6">
                        <input
                            onChange={props.onChange}
                            value={props.city}
                            name="city"
                            type="text"
                            className="form-control"
                            id="city"
                            placeholder="city"
                        />
                    </div>
                </div>

                <div className="form-group row pt-3">
                    <div className="offset-sm-1 col-sm-3  text-center">
                        <button
                            disabled={validateForm()}
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
                            onClick={() => history.push("/coffeeBars")}
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

export default CoffeeBarForm;