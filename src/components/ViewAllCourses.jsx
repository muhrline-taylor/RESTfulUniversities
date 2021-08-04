import React, { useEffect, useState } from 'react'
import MainService from '../services/MainService';

function ViewAllCourses() {
    const [courses, setCourses] = useState([]);

    useEffect(() => {
        MainService.getAllCourses()
            .then(res => {
                setCourses(res.data)
            })
            .catch(err => console.log(err))
    },[])

    return (
        <div className="viewAll">
            <table className="viewAll__table">
                <tr>
                    <th>Course Name</th>
                    <th>Students</th>
                </tr>

                {
                    courses ?
                    courses.map((course, k) => (
                        <tr>
                            <td>{course.course_name}</td>
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

export default ViewAllCourses
