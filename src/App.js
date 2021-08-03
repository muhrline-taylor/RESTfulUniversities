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
          </Switch>
        </Router>
        
      </div>

      <div className="app__body">

        <Router>
          <Switch>
            <Route exact path="/universities/new">createUniversity</Route>
            <Route exact path="/universities/">AllUniversities</Route>
          </Switch>
        </Router>


      </div>
    </div>
  );
}

export default App;
