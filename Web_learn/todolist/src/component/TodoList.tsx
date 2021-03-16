import { useTodosState } from "../context/TodosContext";
import TodoItem from "./TodoItem";


function TodoList() {
    const todos = useTodosState();

    console.log(todos);

    return (
        <ul>
            {todos.map((todo) => (
                <TodoItem key={todo.id} todo={todo} />
            ))}
        </ul>
    );
}

export default TodoList;