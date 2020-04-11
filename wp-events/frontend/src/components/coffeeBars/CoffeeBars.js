import React, {useEffect} from "react";
import {useSelector, useDispatch} from "react-redux";
import {useHistory} from "react-router-dom";
import {removeCoffeeBar, getCoffeeBars} from "../../actions/coffeeBarsActions";
import isEmpty from "lodash.isempty"

function CoffeeBarsTable({coffeeBars, ...rest}) {
    const coffeeBarsList = coffeeBars.map(coffeeBar => {
        return (
            <CoffeeBarItem
                key={coffeeBar.id}
                coffeeBar={coffeeBar}
                onEdit={rest.onEdit}
                onRemove={rest.onRemove}
                onDetails={rest.onDetails}
            />
        );
    });
    return (
        <table className="table tr-history mt-2 col-7">
            <thead className="thead-light">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">City</th>
                <th scope="col" className="text-center w-50">Actions</th>
            </tr>
            </thead>
            <tbody>{coffeeBarsList}</tbody>
        </table>
    );
}

function CoffeeBarItem({coffeeBar, ...rest}) {
    return (
        <tr>
            <td>{coffeeBar.name}</td>
            <td>{coffeeBar.city}</td>
            <td className="d-flex justify-content-center">
                <button onClick={() => rest.onEdit(coffeeBar.id)} className="btn btn-outline-secondary btn-secondary mr-2">
                    <span className="fa fa-edit"/>
                    <span>
                        <strong className="text-white">Edit</strong>
                    </span>
                </button>
                <button onClick={() => rest.onRemove(coffeeBar.id)} className="btn btn-sm btn-outline-danger mr-2">
                    <span className="fa fa-remove"/>
                    <span>
                        <strong className="text-danger">Remove</strong>
                    </span>
                </button>
                <button onClick={() => rest.onDetails(coffeeBar.id)} className="btn btn-sm btn-outline-dark">
                    <span>
                        <strong>Details</strong>
                    </span>
                </button>
            </td>
        </tr>
    );
}

function CoffeeBars(props) {
    const dispatch = useDispatch();
    const history = useHistory();
    const {coffeeBars} = useSelector(state => state.coffeeBars);

    useEffect(() => {
        dispatch(getCoffeeBars());
    }, [dispatch]);

    const onEdit = coffeeBarId => {
        history.push(`/coffeeBars/${coffeeBarId}/edit`);
    };
    const onRemove = coffeeBarId => {
        dispatch(removeCoffeeBar(coffeeBarId, history));
    };
    const onDetails = coffeeBarId => {
        history.push("/coffeeBars/" + coffeeBarId + "/details");
        console.log(coffeeBarId);
    };
    const onNewCoffeeBar = () => {
        history.push("/coffeeBars/new");
    };
    console.log(coffeeBars);
    const coffeeBarsTable = !isEmpty(coffeeBars) ? (
        <CoffeeBarsTable
            coffeeBars={coffeeBars}
            onEdit={onEdit}
            onRemove={onRemove}
            onDetails={onDetails}
            onNewCoffeeBar={onNewCoffeeBar}
        />
    ) : (
        <p>No Coffee Bars</p>
    );
    return (
        <div className="row container m-auto pt-3 pb-5">
            <h4 className="text-upper text-center text-secondary">Coffee Bars</h4>
            <div className="table-responsive m-auto">{coffeeBarsTable}</div>
            <button onClick={onNewCoffeeBar} className="btn btn-outline-secondary">
              <span className="text-dark">
                  add new coffee bar
              </span>
            </button>
        </div>
    );
}

export default CoffeeBars;