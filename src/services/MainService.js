import axios from 'axios';

const UNIVERSITY_API_BASE_URL = "http://localhost:8080/api/v1/universities";
const INSTRUCTOR_API_BASE_URL = "http://localhost:8080/api/v1/instructors";
const STUDENT_API_BASE_URL = "http://localhost:8080/api/v1/students";
const COURSE_API_BASE_URL = "http://localhost:8080/api/v1/courses";

class MainService {

    // API CALLS ================================ //

        // UNIVERSITIES
        getAllUniversities(){
            return axios.get(`${UNIVERSITY_API_BASE_URL}/`);
        }

        // INSTRUCTORS 
        getAllInstructors(){
            return axios.get(`${INSTRUCTOR_API_BASE_URL}/`);
        }

        // STUDENTS
        getAllStudents(){
            return axios.get(`${STUDENT_API_BASE_URL}/`);
        }

        // COURSES
        getAllCourses(){
            return axios.get(`${COURSE_API_BASE_URL}/`);
        }






}


export default new MainService();