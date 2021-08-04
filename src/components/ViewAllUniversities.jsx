import React, { useEffect, useState } from 'react';
import MainService from '../services/MainService';
import "../static/css/ViewAll.css";


function ViewAllUniversities() {
    const [universities, setUniversities] = useState([]);

    useEffect(() => {
        MainService.getAllUniversities()
            .then(res => {
                setUniversities(res.data);
            })
            .catch(err => console.log(err))
    },[])

    return (
        <div className="viewAll">
            <table className="viewAll__table">
                <tr>
                    <th>Name</th>
                    <th>Instructors</th>
                    <th>Courses</th>
                    <th>Students</th>
                </tr>

                {
                    universities ?
                    universities.map((university, k) => (
                        <tr>
                            <td>{university.name}</td>
                            
             {/*           ================================        */}
                            <td>
                                <a href="/UNFINISHED">
                                    Instructors
                                </a>
                            </td>
            
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
                                
            {/*           ================================        */}
                            
                        </tr>
                    )):""
                }

            </table>
        </div>
    )
}

export default ViewAllUniversities
