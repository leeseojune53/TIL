import logo from './logo.svg';
import './App.css';
import { getMessaging, getToken } from 'firebase/messaging';
import { initializeApp } from '@firebase/app';

function App() {

  const firebaseConfig = {
    apiKey: "AIzaSyBQ0Kk6AHcbfFpK0LfwF_ueUBKGWYesM68",
    authDomain: "tn1-server.firebaseapp.com",
    projectId: "tn1-server",
    storageBucket: "tn1-server.appspot.com",
    messagingSenderId: "402437514549",
    appId: "1:402437514549:web:a46a6a82c809b7b3dfd87c",
    measurementId: "G-K59X6GZRLM"
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

  getToken(messaging, {vapidKey: 'BGEMmQHcklPoxd8EQ-GtCN-eQGKdPdlLuc-lTAu_HVDfX7OTDJ734cXBWM8fuZcolPchXMmDdr0mnURxmODPU6o'}).then((currentToken) => {
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
          Edit <code>src/App.js</code> and save to reload.
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
