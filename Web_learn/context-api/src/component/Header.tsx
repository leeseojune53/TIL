import { useContext } from "react";
import { AppContext } from "../context/contextApiContext";

function Header() {
  const appContext = useContext(AppContext);

  return (
    <div style={{ backgroundColor: appContext?.isDark ? "black" : "white" }}>
      HIHI
    </div>
  );
}

export default Header;
