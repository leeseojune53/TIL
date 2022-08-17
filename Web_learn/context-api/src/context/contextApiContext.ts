import { createContext } from "react";

export interface AppContextInterface {
  isDark: boolean;
  setIsDark: Function;
}

export const AppContext = createContext<AppContextInterface | null>(null);
