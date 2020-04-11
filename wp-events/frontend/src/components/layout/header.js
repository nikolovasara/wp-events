import React from "react";
import {Link} from "react-router-dom";

function Header(props) {
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-light navbar-fixed bg-light">
                <div className="container">
                    <Link className="nav-link text-danger" to={"/"}>
                        Home
                    </Link>
                    <button
                        className="navbar-toggler"
                        type="button"
                        data-toggle="collapse"
                        data-target="#navbarCollapse"
                        aria-controls="navbarCollapse"
                        aria-expanded="false"
                        aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"/>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarCollapse">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item">
                                <Link className="nav-link" to="/events">
                                    Music Events
                                </Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/coffeeBars">
                                    Coffee Bar
                                </Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link btn btn-outline-secondary my-2 my-sm-0 ml-3" to="/events/new">
                                        Add Event
                                </Link>
                            </li>
                        </ul>
                        <form className="form-inline mt-2 mt-md-0 ml-3">
                            <a className="btn btn-outline-danger my-2 my-sm-0" href="/">
                                Login
                            </a>
                        </form>
                    </div>
                </div>
            </nav>
        </header>
    );
}

export default Header;