import React, {useState} from "react";
import {useParams, useHistory} from "react-router-dom";
import {useSelector, useDispatch} from "react-redux";
import CoffeeBarForm from "./CoffeeBarForm";
import {editCoffeeBar} from "../../actions/coffeeBarsActions";

function EditCoffeeBar(props) {
    const dispatch = useDispatch();
    const params = useParams();
    const history = useHistory();
    const {coffeeBars} = useSelector(state => state.coffeeBars);

    const curCoffeeBar = coffeeBars.find(cb => cb.id === params.coffeeBarId) || {};
    const [coffeeBar, setCoffeeBar] = useState({
        name: curCoffeeBar.name || "",
        city: curCoffeeBar.city || ""
    });
    const onChange = e => {
        e.persist();
        setCoffeeBar(s => ({...s, [e.target.name]: e.target.value}));
    };
    const onSubmit = e => {
        e.preventDefault();
        dispatch(editCoffeeBar(coffeeBar, history));
    };
    const onReset = () => {
        setCoffeeBar(s => ({name: "", city: ""}));
    };
    return (
        <CoffeeBarForm
            heading="Edit"
            onChange={onChange}
            onSubmit={onSubmit}
            onReset={onReset}
            name={coffeeBar.name}
            city={coffeeBar.city}
        />
    );
}

export default EditCoffeeBar;