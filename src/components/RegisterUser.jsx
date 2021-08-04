import React, { useState } from 'react';
import "../static/css/RegisterUser.css";

function RegisterUser() {
    const [registerForm, setRegisterForm] = useState({
        username: "",
        email: "",
        password: "",
        confirm_pw: ""
    })
    
    const changeHandler = e => {
        setRegisterForm({
            ...registerForm,
            [e.target.name]: e.target.value
        })
    }

    const clickHandler = e => {
        e.preventDefault();
    }

    return (
        <div className="registerUser">
            
            <div className="registerUser__content">

                <form className="registerUser__contentForm">

                    <p>
                        ERRORS ERRORS ERRORS ERRORS ERRORS ERRORS ERRORS ERRORS
                    </p>
                    <input 
                        className="registerUser__contentForm--input"
                        placeholder="Username..."
                        name="username"
                        value={registerForm.username}
                        onChange={changeHandler}
                    />

                    <p>
                        ERRORS ERRORS ERRORS ERRORS ERRORS ERRORS ERRORS ERRORS
                    </p>
                    <input 
                        className="registerUser__contentForm--input"
                        placeholder="Email..."
                        name="email"
                        value={registerForm.email}
                        onChange={changeHandler}
                    />

                    <p> 
                        ERRORS ERRORS ERRORS ERRORS ERRORS ERRORS ERRORS ERRORS
                    </p>
                    <input 
                        className="registerUser__contentForm--input"
                        placeholder="Password..."
                        name="password"
                        value={registerForm.password}
                        onChange={changeHandler}
                    />

                    <p>
                        ERRORS ERRORS ERRORS ERRORS ERRORS ERRORS ERRORS ERRORS
                    </p>
                    <input 
                        className="registerUser__contentForm--input"
                        placeholder="Confirm Password..."
                        name="confirm_pw"
                        value={registerForm.confirm_pw}
                        onChange={changeHandler}
                    />

                    <input 
                        className="registerUser__contentForm--button"
                        type="submit"
                        value="Register"
                        onClick={clickHandler}
                    />

                </form>


            </div>




        </div>
    )
}

export default RegisterUser
