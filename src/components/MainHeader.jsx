import React, { useEffect, useState } from 'react';
import "../static/css/MainHeader.css";

function MainHeader({ ...props }) {
    const [tabSelected, setTabSelected] = useState("")

    useEffect(() => {
        setTabSelected("");
        var newTab = "";
        for(let i=22;i<window.location.href.length;i++){
            if(window.location.href.charAt(i) === "/"){
                break
            }
            newTab += window.location.href.charAt(i);
        }
        setTabSelected(newTab);
    },[tabSelected])

    return (
        <div className="mainHeader">
            <div className="mainHeader__top">
                <h1>RESTful Universities</h1>
            </div>
            <div className="mainHeader__middle">

                <a 
                    href="/universities"
                    className={`mainHeader__middleButton ${tabSelected === "universities" ? "__selected":""}`}
                >
                    Universities
                </a>

                <a 
                    href="/instructors"
                    className={`mainHeader__middleButton ${tabSelected === "instructors" ? "__selected":""}`}
                >
                    Instructors
                </a>

                <a 
                    href="/courses"
                    className={`mainHeader__middleButton ${tabSelected === "courses" ? "__selected":""}`}
                >
                    Courses
                </a>

                <a 
                    href="/students"
                    className={`mainHeader__middleButton ${tabSelected === "students" ? "__selected":""}`}
                >
                    Students
                </a>

                <a 
                    href="/accounts"
                    className={`mainHeader__middleButton ${tabSelected === "accounts" ? "__selected":""}`}
                >
                    Account
                </a>
            </div>
            
        </div>
    )
}

export default MainHeader
