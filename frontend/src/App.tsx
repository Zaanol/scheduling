import React from 'react';
import logo from './logo.svg';
import './App.css';
import { Button } from '@material-ui/core';
import { BiAlarm } from "react-icons/bi";
import {InputBase} from "./components/InputBase";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
          <InputBase color='secondary' onChange={(e) => console.log(e)} value='aaaaaa'/>
      </header>
      <Button variant="contained" color="primary">Hello World <BiAlarm/></Button>
    </div>
  );
}

export default App;
