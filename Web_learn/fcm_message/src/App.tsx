import React from 'react';
import logo from './logo.svg';
import './App.css';
import { initializeApp } from '@firebase/app';
import { getMessaging, getToken } from 'firebase/messaging';

function App() {

  const firebaseConfig = {
    apiKey: process.env.REACT_APP_API_KEY,
    authDomain: "",
    projectId: "",
    storageBucket: "",
    messagingSenderId: "",
    appId: "",
    measurementId: ""
  };


  const app = initializeApp(firebaseConfig);

  const messaging = getMessaging(app);

  Notification.requestPermission().then(function(permission) {
    if (permission === 'granted') {
      console.log('Notification permission granted.');
    } else {
      console.log('Unable to get permission to notify.');
    }
  });

  getToken(messaging, {vapidKey: ''}).then((currentToken) => {
    if (currentToken) {
      console.log(currentToken);
    } else {
      // Show permission request UI
      console.log('No registration token available. Request permission to generate one.');
      // ...
    }
  }).catch((err) => {
    console.log('An error occurred while retrieving token. ', err);
    // ...
  });

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
      </header>
    </div>
  );
}

export default App;
