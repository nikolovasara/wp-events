import React from "react";
import logo from "./Logo.PNG";
function Home(props) {
    return <div className="container mx-auto mt-0 text-center">
        <img src={logo} alt={"logo"}/>
        <h1>Web Programming</h1>
        <hr className={"w-25"}/>
        <p>React & Spring Boot</p>
        <hr className="bg-dark"/>
        <footer className="text-secondary text-sm-left m-auto">&copy;FCSE, 2020</footer>

    </div>;
}

export default Home;
