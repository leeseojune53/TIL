import type { NextPage } from "next";
import Head from "next/head";
import Image from "next/image";
import { useState } from "react";
import InputBox from "../components/Inputbox";
import Todo from "../components/Todo";
import styles from "../styles/Home.module.css";

export type TodoType = {
  id: number;
  value: string;
  checked: boolean;
};

const Home: NextPage = () => {
  let id = 1;
  const [todoList, setTodoList] = useState<TodoType[]>([]);

  const addValue = (value: string) => {
    setTodoList([...todoList, { id: id++, value: value, checked: false }]);
  };

  const onCheck = (id: number) => {
    let todo = todoList.find((element) => element.id === id);
    if (todo) {
      todo.checked = !todo.checked;
    } else {
      alert("존재하지 않는 Todo입니다.");
    }
  };

  const onDelete = (id: number) => {
    setTodoList(
      todoList.filter((element) => {
        element.id === id;
      })
    );
  };

  return (
    <div>
      <InputBox addValue={addValue}></InputBox>
      {todoList.map((value) => (
        <Todo todo={value} onCheck={onCheck} onDelete={onDelete} />
      ))}
    </div>
  );
};

export default Home;
