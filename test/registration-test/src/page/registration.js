import axios from "axios";
import { useState } from "react";
import "../component/registration.css";

function Register() {
    const [id, setId] = useState("");
    const [name, setname] = useState("");
    // const [lastname, setLname] = useState("");
    const [email, setemail] = useState("");
    const [phNo, setphNo] = useState("");
    const [doctor_password, setdoctor_password] = useState("");

    async function handleSubmit(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8082/signup", {
                id: id,
                name: name,
                // lname : lastname,
                email: email,
                phNo: phNo,
                doctor_password: doctor_password
            });
            alert("User Registation Successfully");
            setId("");
            setname("");
            //  setLname("");
            setemail("");
            setphNo("");
            setdoctor_password("");

        } catch (err) {
            alert("User Registation Failed");
        }
    }
    return ( 
        <div className = "register-container">

        <form className = "register-form"  onSubmit = { handleSubmit }>
               
        <h1> Register </h1> 
        <p> Fill in the Information Below </p>

        {/* <input type = "text"
        name = "id"
        placeholder = "id"

        onChange = {
            (event) => {
                setId(event.target.value);
            }
        }
        /> */}

        <input type = "text"
        name = "name"
        placeholder = "Enter your name"
        onChange = {
            (event) => {
                setname(event.target.value);
            }
        }
        />

        


        <input type = "text"
        name = "email"
        placeholder = "Enter your email as username"
        onChange = {
            (event) => {
                setemail(event.target.value);
            }
        }
        />
        <input type = "text"
        name = "phNo"
        placeholder = "Enter your Phone Number"
        onChange = {
            (event) => {
                setphNo(event.target.value);
            }
        }
        />

        <input type = "text"
        name = "doctor_password"
        placeholder = "Enter your password"
        onChange = {
            (event) => {
                setdoctor_password(event.target.value);
            }
        }
        />

        <button type = "submit" > Register </button>


        </form>     


        </div>
    )
}

export default Register;