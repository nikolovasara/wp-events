import React from 'react';
import './App.css';
import { Route, Redirect, Switch, BrowserRouter } from "react-router-dom";
import Home from "./components/home/Home";
import Header from "./components/layout/header";
import CoffeeBars from "./components/coffeeBars/CoffeeBars";
import NewCoffeeBar from "./components/coffeeBars/NewCoffeeBar";
import EditCoffeeBar from "./components/coffeeBars/EditCoffeeBar";
import Details from "./components/coffeeBars/Details";
import EventSlots from "./components/eventSlots/EventSlots";
import NewEventSlot from "./components/eventSlots/NewEventSlot";

function App(props) {
  return (
      <BrowserRouter>
        <Header />
          <Switch>
            <Route exact path="/" component={Home} />
            <Route exact path="/events" component={EventSlots} />
            <Route exact path="/events/new" component={NewEventSlot} />
              <Route
                  exact
                  path="/events/:slotId/new"
                  component={NewEventSlot}
              />

            <Route exact path="/coffeeBars" component={CoffeeBars}/>
            <Route exact path="/coffeeBars/new" component={NewCoffeeBar} />
            <Route
                exact
                path="/coffeeBars/:coffeeBarId/new"
                component={NewCoffeeBar}
            />
            <Route
                exact
                path="/coffeeBars/:coffeeBarId/edit"
                component={EditCoffeeBar}
            />
            <Route
                exact
                path="/coffeeBars/:coffeeBarId/details"
                component={Details}
            />
            <Redirect to="/" />
          </Switch>
      </BrowserRouter>
  );
}


export default App;
