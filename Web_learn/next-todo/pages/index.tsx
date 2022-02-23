import type { NextPage } from "next";
import Head from "next/head";
import Image from "next/image";
import { useState } from "react";
import InputBox from "../components/Inputbox";
import Todo from "../components/Todo";
import styles from "../styles/Home.module.css";

const Home: NextPage = () => {
  const [todoList, setTodoList] = useState<string[]>([]);
  const addValue = (value: string) => {
    setTodoList([...todoList, value]);
  };

  return (
    <div>
      <InputBox addValue={addValue}></InputBox>
      {todoList.map((value) => (
        <Todo todo={value} />
      ))}
    </div>
  );
};

export default Home;
