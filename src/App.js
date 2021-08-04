import MainHeader from './components/MainHeader';
import './static/css/App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import UniversitySubHeader from './components/UniversitySubHeader';
import InstructorSubHeader from './components/InstructorSubHeader';
import CoursesSubHeader from './components/CoursesSubHeader';
import StudentSubHeader from './components/StudentSubHeader';
import ViewAllUniversities from './components/ViewAllUniversities';
import ViewAllInstructors from './components/ViewAllInstructors';
import ViewAllCourses from './components/ViewAllCourses';
import ViewAllStudents from './components/ViewAllStudents';
import CreateUniversity from './components/CreateUniversity';
import AccountsSubHeader from './components/AccountsSubHeader';
import RegisterUser from './components/RegisterUser';

function App() {
  return (
    <div className="app">
      <div className="app__header">
        <MainHeader />
        <Router>
          <Switch>
            <Route path="/universities"><UniversitySubHeader /></Route>
            <Route path="/instructors"><InstructorSubHeader /></Route>
            <Route path="/courses"><CoursesSubHeader /></Route>
            <Route path="/students"><StudentSubHeader /></Route>
            <Route path="/accounts"><AccountsSubHeader /></Route>
          </Switch>
        </Router>
        
      </div>

      <div className="app__body">

        <Router>

          <Switch>
            <Route exact path="/universities/new"><CreateUniversity /></Route>
            <Route exact path="/universities/"><ViewAllUniversities /></Route>
          </Switch>

          <Switch>
            <Route exact path="/instructors/"><ViewAllInstructors /></Route>
          </Switch>

          <Switch>
            <Route exact path="/courses/"><ViewAllCourses /></Route>
          </Switch>

          <Switch>
            <Route exact path="/students/"><ViewAllStudents /></Route>
          </Switch>

          <Switch>
            <Route exact path="/accounts/register"><RegisterUser /></Route>
            <Route exact path="/accounts/login">Login()</Route>
          </Switch>
        </Router>


      </div>
    </div>
  );
}

export default App;
