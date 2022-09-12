import PropTypes from 'prop-types'
import React, { Component } from 'react'
import { Router, Switch, Route, Link } from "react-router-dom";
import { FaHome, FaUserPlus, FaSignInAlt } from "react-icons/fa";

export class Navbar_beforelogin extends Component {
  static propTypes = {}

  render() {
    return (
      <div>
        <nav className="navbar navbar-expand navbar-dark">
            <Link to={"/"} className="navbar-brand">
              <h5>
                <FaHome /> XYZ Pharmacy
              </h5>
            </Link>
            {/* <div className="navbar-nav mr-auto">
              
            </div> */}

               
              <div className="navbar-nav ms-auto" >
                <li className="nav-item">
                  <Link to={"/login"} className="nav-link">
                    <FaSignInAlt /> <h5> Signin</h5>
                  
                  </Link>
                </li>

                <li className="nav-item">
                  <Link to={"/register"} className="nav-link">
                    <FaUserPlus /> <h5> Sign Up </h5>
                  </Link>
                </li>
              </div>
       
          </nav>
      </div>
    )
  }
}

export default Navbar_beforelogin