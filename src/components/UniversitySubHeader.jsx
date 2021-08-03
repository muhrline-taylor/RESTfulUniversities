import React from 'react';
import "../static/css/SubHeader.css";

function UniversitySubHeader() {
    return (
        <div className="subHeader">

            <a 
                href="/universities/"
                className="subHeader__button"
            >
                View All
            </a>

            <a 
                href="/universities/new"
                className="subHeader__button"
            >
                Create
            </a>

            

        </div>
    )
}

export default UniversitySubHeader
