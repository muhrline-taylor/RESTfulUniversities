import React from 'react';
import "../static/css/SubHeader.css";

function StudentSubHeader() {
    return (
        <div className="subHeader">

            <a 
                href="/students/"
                className="subHeader__button"
            >
                View All
            </a>

            <a 
                href="/students/new"
                className="subHeader__button"
            >
                Create
            </a>

            

        </div>
    )
}

export default StudentSubHeader
