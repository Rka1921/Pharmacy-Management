import React, { Component } from "react";
import Navbar from "./Navbar";
 
class Home extends Component {
  render() {
    return (
        <div>
            <Navbar/>
      
      <div>
        <h2>WELCOME to XYZ Pharmacy</h2>
        <br></br>
            <div>
                <p><i>This is a one stop solution to all the Pharmacies. Here order your medicine from our place
                    and get it as soon as possible.
                    </i></p>
            </div> 
            <section>
                    <p>A dummy project developed by a bunch of engineers..Deploying.....</p>
            </section>
           
      </div>
      </div>


      //<p>A dummy project developed by a bunch of engineers..Deploying.....</p>
    );
  }
}
 
export default Home;
