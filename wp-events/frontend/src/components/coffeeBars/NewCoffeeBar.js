import React, {useState} from "react";
import {useDispatch} from "react-redux";
import {useHistory} from "react-router";
import CoffeeBarForm from "./CoffeeBarForm";
import {newCoffeeBar} from "../../actions/coffeeBarsActions";

function NewCoffeeBar(props) {
    const dispatch = useDispatch();
    const history = useHistory();
    const [coffeeBar, setCoffeeBar] = useState({
        name: "",
        city: ""
    });

    const onChange = e => {
        e.persist();
        setCoffeeBar(s=>({...s,[e.target.name]: e.target.value}));
    };
    const onSubmit = e => {
        e.preventDefault();
        dispatch(newCoffeeBar(coffeeBar,history));
    };
    const onReset = () => {
        setCoffeeBar(s => ({ name: "", city: ""}));
    };


    return (
        <CoffeeBarForm
        heading="New"
        onChange={onChange}
        onSubmit={onSubmit}
        onReset={onReset}
        name={coffeeBar.name}
        city={coffeeBar.city}
        />
    );
}
export default NewCoffeeBar;