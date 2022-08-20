import { useContext } from "react";
import { AppContext } from "../context/contextApiContext";

function Content() {
  const appContext = useContext(AppContext);

  return (
    <div
      className="App-Content"
      style={{ backgroundColor: appContext?.isDark ? "black" : "white" }}
    >
      HIR
    </div>
  );
}

export default Content;
