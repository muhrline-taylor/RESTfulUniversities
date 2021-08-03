import React, { useEffect, useState } from 'react';
import "../static/css/MainHeader.css";

function MainHeader() {
    const [tabSelected, setTabSelected] = useState("")

    const clickHandler = e => {
        setTabSelected(e.target.value)
    }

    useEffect(() => {
        console.log(tabSelected);
    },[])

    return (
        <div className="mainHeader">
            <div className="mainHeader__top">
                <h1>RESTful Universities</h1>
            </div>
            <div className="mainHeader__middle">

                <a 
                    href="/universities"
                    className="mainHeader__middleButton"
                >
                    Universities
                </a>

                <a 
                    href="/instructors"
                    className="mainHeader__middleButton"
                >
                    Instructors
                </a>

                <a 
                    href="/courses"
                    className="mainHeader__middleButton"
                >
                    Courses
                </a>

                <a 
                    href="/students"
                    className="mainHeader__middleButton"
                >
                    Students
                </a>
            </div>
            
        </div>
    )
}

export default MainHeader
