import React, { Component } from 'react'
import signupservice from '../service/signupservice'
class CreateDoctorsComponent extends Component{
    constructor(props) {
        super(props)
        this.state = {
            // step 2
            id: this.props.match.params.id,
          name: '',
           phNo: '',
            email: '',
            doctor_password:''
        }
        this.changenameHandler = this.changenameHandler.bind(this);
        this.changephNoHandler = this.changephNoHandler.bind(this);
        this.saveOrUpdateDoctor = this.saveOrUpdateDoctor.bind(this);
    }
        componentDidMount(){

            // step 4
            if(this.state.id === '_add'){
                return
            }else{
               signupservice.createDoctors(this.state.id).then( (res) =>{
                    let doctor= res.data;
                    this.setState({name: doctor.name,
                        phNo: doctor.phNo,
                        email : doctor.email
                    });
                });
                }
        //     }    
                
         }
        saveOrUpdateDoctor = (e) => {
            e.preventDefault();
            let doctor = {name: this.state.name, phNo: this.state.phNo, email: this.state.email, doctor_password:this.state.doctor_password};
            console.log('doctor => ' + JSON.stringify(doctor));
    
            // step 5
            if(this.state.id === '_add'){
                signupservice.createDoctors(doctor).then(res =>{
                    this.props.history.push('/doctorsData');
                });
            // }else{
            //     EmployeeService.updateEmployee(employee, this.state.id).then( res => {
            //         this.props.history.push('/employees');
            //     }
            
            }

        }
        changenameHandler= (event) => {
            this.setState({name: event.target.value});
        }
    
        changephNoHandler= (event) => {
            this.setState({phNo: event.target.value});
        }
    
        changeemailHandler= (event) => {
            this.setState({email: event.target.value});
        }
       
        changepasswordHandler= (event) => {
            this.setState({doctor_password: event.target.value});
        }
        cancel(){
            this.props.history.push('/doctorsData');
        }
    
        getTitle(){
            if(this.state.id === '_add'){
                return <h3 className="text-center">Sign Up</h3>}
            // }else{
            //     return <h3 className="text-center">Update Employee</h3>
            // }
        }
        render() {
            return (
                <div>
                    <br></br>
                       <div className = "container">
                            <div className = "row">
                                <div className = "card col-md-6 offset-md-3 offset-md-3">
                                    {
                                        this.getTitle()
                                    }
                                    <div className = "card-body">
                                        <form>
                                            <div className = "form-group">
                                                <label>  Name: </label>
                                                <input placeholder=" Name" name="name" className="form-control" 
                                                    value={this.state.name} onChange={this.changenameHandler}/>
                                            </div>
                                            <div className = "form-group">
                                                <label> Phone Number: </label>
                                                <input placeholder=" Phone Number" name="phNo" className="form-control" 
                                                    value={this.state.phNo} onChange={this.changephNoHandler}/>
                                            </div>
                                            <div className = "form-group">
                                                <label> Email Id: </label>
                                                <input placeholder="Email Address" name="email" className="form-control" 
                                                    value={this.state.email} onChange={this.changeemailHandler}/>
                                            </div>
                                            <div className = "form-group">
                                                <label> Password: </label>
                                                <input placeholder="Password" name="doctor_password" className="form-control" 
                                                    value={this.state.doctor_password} onChange={this.changepasswordHandler}/>
                                            </div>
    
                                            <button className="btn btn-success" onClick={this.saveOrUpdateDoctor}>Save</button>
                                            <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
    
                       </div>
                </div>
            )
        }
    }
export default CreateDoctorsComponent



