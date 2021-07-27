import { BrowserRouter, Switch, Route } from "react-router-dom";
import { createStore } from "redux";

import Main from "./pages/Main";
import Room from './pages/Room'

import "./App.css";

const App = () => {
  return (
    <>
      <BrowserRouter>
        <Switch>
          <Route exact path="/" component={Main} />
          <Route exact path="/room" component={Room} />
        </Switch>
      </BrowserRouter>
    </>
  );
};

export default App;
