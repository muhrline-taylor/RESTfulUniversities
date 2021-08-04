import React, { useEffect, useState } from 'react'
import MainService from '../services/MainService';

function ViewAllStudents() {
    const [students, setStudents] = useState([]);

    useEffect(() => {
        MainService.getAllStudents()
            .then(res => {
                setStudents(res.data)
            })
            .catch(err => console.log(err))
    },[])

    return (
        <div className="viewAll">
            <table className="viewAll__table">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>

                {
                    students ?
                    students.map((student, k) => (
                        <tr>
                            <td>{student.fname}</td>
                            <td>{student.lname}</td>
                        </tr>
                    )):""
                }

            </table>
        </div>
    )
}

export default ViewAllStudents
