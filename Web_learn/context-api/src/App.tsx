import React, { useState } from "react";
import logo from "./logo.svg";
import "./App.css";
import { AppContext, AppContextInterface } from "./context/contextApiContext";
import Header from "./component/Header";
import Content from "./component/Content";

function App() {
  const [isDark, setIsDart] = useState(false);

  const appContext: AppContextInterface = {
    isDark: isDark,
    setIsDark: setIsDart,
  };

  const changeMode = (): void => {
    setIsDart(!isDark);
  };

  return (
    <AppContext.Provider value={appContext}>
      <Header></Header>
      <Content></Content>
      <button onClick={changeMode}></button>
    </AppContext.Provider>
  );
}

export default App;
