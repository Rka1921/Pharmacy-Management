import { render } from "@testing-library/react";
import React, { Component } from "react";
function Navbar(){
    return(
        <nav class="navbar navbar-expand-sm text-white">
  <div class="container-fluid">
    <a class="navbar-brand text-white" href="javascript:void(0)"><h3>XYZ Pharmacy</h3></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="colapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item ">
          <a class="nav-link " href="/"><h4>Home</h4></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/add"><h4>Drugs</h4></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)"><h4>Doctors</h4></a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2 " type="text" placeholder="Search Drugs  "/>
        <button class="btn text-white" type="button">Search</button>
      </form>
    </div>
  </div>
</nav>


    );
}
export default Navbar;