import React from 'react';
import './App.css';
import {Route, Switch, BrowserRouter as Router} from 'react-router-dom';
import Login from "./Login/Login";
import Lobby from "./Lobby/Lobby";
import OngoingMatches from './Lobby/Ongoing Matches/OngoingMatches';
import MatchHistory from './Lobby/Match History/MatchHistory';
import BoardGame from './BoardGame/BoardGame';

function App() {
  return (
    <div className="App">
      <Router>
        <div id='switches'>
          <Switch>
            <Route exact path="/" component={Login} />
            <Route exact path="/lobby" component={Lobby} />
            <Route exact path="/matches" component={OngoingMatches} />
            <Route exact path="/history" component={MatchHistory} />
            <Route exact path="/game" component={BoardGame} />
          </Switch>
        </div>
      </Router>
    </div>
  );
}

export default App;
