import React from 'react';
import "../static/css/SubHeader.css";

function InstructorSubHeader() {
    return (
        <div className="subHeader">

            <a 
                href="/instructors/"
                className="subHeader__button"
            >
                View All
            </a>

            <a 
                href="/instructors/new"
                className="subHeader__button"
            >
                Create
            </a>

            

        </div>
    )
}

export default InstructorSubHeader
