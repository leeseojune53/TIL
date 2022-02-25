import type { NextPage } from "next";
import Head from "next/head";
import Image from "next/image";
import { useEffect, useState } from "react";
import Input from "../components/Input";
import Todo from "../components/Todo";
import styles from "../styles/Home.module.css";

export type TodoType = {
  id: number;
  value: string;
  checked: boolean;
};

const Home: NextPage = () => {
  const [todoList, setTodoList] = useState<TodoType[]>([]);
  const [cursor, setCursor] = useState<number>(0);

  const addValue = (value: string) => {
    setCursor(cursor + 1);
    setTodoList([...todoList, { id: cursor, value: value, checked: false }]);
  };

  const onCheck = (id: number) => {
    let todo = todoList.map((e) => e.id === id);
    if (todo) {
      setTodoList(
        todoList.map((e) => (e.id === id ? { ...e, checked: !e.checked } : e))
      );
    } else {
      alert("존재하지 않는 Todo입니다.");
    }
  };

  const onDelete = (id: number) => {
    setTodoList(todoList.filter((e) => e.id !== id));
  };

  return (
    <div>
      <Input addValue={addValue}></Input>
      {todoList.map((value) => (
        <Todo
          key={value.id}
          todo={value}
          onCheck={onCheck}
          onDelete={onDelete}
        />
      ))}
    </div>
  );
};

export default Home;
