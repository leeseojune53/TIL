import type { NextPage } from "next";
import Head from "next/head";
import Image from "next/image";
import View from "../components/header";
import styles from "../styles/Home.module.css";

const Home: NextPage = () => {
  const todoList = ["todo1", "todo2"];
  return (
    <div>
      {todoList.map((value) => (
        <View todo={value} />
      ))}
      <View todo="todo list1." />
      <View todo="todo list2." />
    </div>
  );
};

export default Home;
