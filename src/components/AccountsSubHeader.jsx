import React, { useState, useEffect } from 'react';
import "../static/css/SubHeader.css";

function AccountsSubHeader() {
    const [tabSelected, setTabSelected] = useState("")

    useEffect(() => {
        setTabSelected("");
        var newTab = "";
        console.log(window.location.href);
        for(let i=30;i<window.location.href.length;i++){
            newTab += window.location.href.charAt(i);
            console.log(window.location.href.charAt(i));
        }
        setTabSelected(newTab);
    },[tabSelected])

    return (
        <div className="subHeader">

            <a 
                href="/accounts/login"
                className={`subHeader__button ${tabSelected === "/login" ? "__selected": ""}`}
            >
                Log In
            </a>

            <a 
                href="/accounts/register"
                className={`subHeader__button ${tabSelected === "/register" ? "__selected": ""}`}
            >
                Register
            </a>

            

        </div>
    )
}

export default AccountsSubHeader
