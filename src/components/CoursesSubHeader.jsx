import React from 'react';
import "../static/css/SubHeader.css";

function CourseSubHeader() {
    return (
        <div className="subHeader">

            <a 
                href="/courses/"
                className="subHeader__button"
            >
                View All
            </a>

            <a 
                href="/courses/new"
                className="subHeader__button"
            >
                Create
            </a>

            

        </div>
    )
}

export default CourseSubHeader
