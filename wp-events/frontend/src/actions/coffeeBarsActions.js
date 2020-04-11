import axios from "axios";
import { SET_COFFEE_BARS, SET_RESPONSE_MESSAGE} from "./types";

export const getCoffeeBars = () => async dispatch => {
    try{
        console.log("Should get all coffee bars");
        const coffeeBars=await axios.get(`/coffeeBars`);
        console.log(coffeeBars.data);
        dispatch({ type: SET_COFFEE_BARS, payload: coffeeBars.data});
    } catch (e) {
        console.log(e);
    }
};

export const removeCoffeeBar = (id, history) => async dispatch => {
  try{
      console.log("Remove coffee bar with name ", id);
      const responseMessage=await axios.delete(`/coffeeBars/${id}`);
      dispatch({ type: SET_RESPONSE_MESSAGE, payload: responseMessage.data});
      history.push("/coffeeBars");
  }
  catch (e) {
      console.log(e);
  }
};

export const editCoffeeBar = (coffeeBar, history) => async dispatch =>{
    try{
        console.log("Edit coffee bar data ", coffeeBar);
        const responseMessage=await axios.patch(
          `/coffeeBars/${coffeeBar.id}`,
            null,
            {
                params:{
                    name: coffeeBar.name,
                    city: coffeeBar.city
                }
            }
        );
        dispatch({ type: SET_RESPONSE_MESSAGE, payload: responseMessage.data });
        history && history.push("/coffeeBars");
    }
    catch (e) {
        console.log(e);
    }
};

export const newCoffeeBar = (coffeeBar, history) =>async dispatch => {
    try{
        console.log("New Coffee Bar ", coffeeBar);
        const responseMessage = await axios.post(`/coffeeBars/`, null, {
            params: {
                name: coffeeBar.name,
                city: coffeeBar.city
            }
        });
        dispatch({ type: SET_RESPONSE_MESSAGE, payload: responseMessage.data });
        history && history.push("/coffeeBars");
    }
    catch (e) {
        console.log(e);
    }
};