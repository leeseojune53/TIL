import { initializeApp } from "firebase/app";
import { getMessaging } from "firebase/messaging/sw";

// Initialize the Firebase app in the service worker by passing in
// your app's Firebase config object.
// https://firebase.google.com/docs/web/setup#config-object
const firebaseApp = initializeApp({
    apiKey: "AIzaSyBQ0Kk6AHcbfFpK0LfwF_ueUBKGWYesM68",
    authDomain: "tn1-server.firebaseapp.com",
    projectId: "tn1-server",
    storageBucket: "tn1-server.appspot.com",
    messagingSenderId: "402437514549",
    appId: "1:402437514549:web:a46a6a82c809b7b3dfd87c",
    measurementId: "G-K59X6GZRLM"
  });

// Retrieve an instance of Firebase Messaging so that it can handle background
// messages.
const messaging = getMessaging(firebaseApp);