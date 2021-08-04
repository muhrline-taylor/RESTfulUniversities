import React, { useState, useEffect } from 'react';
import MainService from '../services/MainService';
import "../static/css/ViewAll.css";

function ViewAllInstructors() {
    const [instructors, setInstructors] = useState([]);

    useEffect(() => {
        MainService.getAllInstructors()
            .then(res => {
                setInstructors(res.data);
            })
            .catch(err => console.log(err))
    },[])

    return (
        <div>
            <table className="viewAll__table">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Courses</th>
                    <th>Students</th>
                </tr>

                {
                    instructors ?
                    instructors.map((instructor, k) => (
                        <tr>
                            <td>{instructor.fname}</td>
                            <td>{instructor.lname}</td>
                            <td>
                                <a href="/UNFINISHED">
                                    Courses
                                </a>
                            </td>
                            <td>
                                <a href="/UNFINISHED">
                                    Students
                                </a>
                            </td>
                        </tr>
                    )):""
                }

            </table>
        </div>
    )
}

export default ViewAllInstructors
