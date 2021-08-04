import React, { useState, useEffect } from 'react';
import "../static/css/SubHeader.css";

function InstructorSubHeader() {
    const [tabSelected, setTabSelected] = useState("")

    useEffect(() => {
        setTabSelected("");
        var newTab = "";
        console.log(window.location.href);
        for(let i=33;i<window.location.href.length;i++){
            newTab += window.location.href.charAt(i);
            console.log(window.location.href.charAt(i));
        }
        setTabSelected(newTab);
    },[tabSelected])


    return (
        <div className="subHeader">

            <a 
                href="/instructors/"
                className={`subHeader__button ${tabSelected === "/" ? "__selected":""}`}
            >
                View All
            </a>

            <a 
                href="/instructors/new"
                className={`subHeader__button ${tabSelected === "/new" ? "__selected":""}`}
            >
                Create
            </a>

            

        </div>
    )
}

export default InstructorSubHeader
