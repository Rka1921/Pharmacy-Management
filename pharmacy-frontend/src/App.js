import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
// import './App.css';
import CreateDoctorsComponent from  './component/CreateDoctorComponent.jsx';
function App() {
  return (
    <div>
    <Router>
          
            <div className="container">
                <Routes> 
                      {/* <Route path = "/" exact component = {ListEmployeeComponent}></Route> */}
                      {/* <Route path = "/employees" component = {ListEmployeeComponent}></Route> */}
                      <Route path = "/add-doctor/:id" component = {CreateDoctorsComponent}></Route>
                      {/* <Route path = "/view-employee/:id" component = {ViewEmployeeComponent}></Route> */}
                      {/* <Route path = "/update-employee/:id" component = {UpdateEmployeeComponent}></Route> */}
                </Routes>
            </div>
          
    </Router>
</div>

  );
}

export default App;
