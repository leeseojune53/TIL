import React, { useState, useCallback, ChangeEvent, KeyboardEvent } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import './App.css';
import TodoForm from './component/TodoForm';
import TodoList from './component/TodoList';
import { TodosContextProvider } from './context/TodosContext';

const App = () => {
    return (
        <TodosContextProvider>
            <TodoForm/>
            <TodoList/>
        </TodosContextProvider>
    )
}

export default App;