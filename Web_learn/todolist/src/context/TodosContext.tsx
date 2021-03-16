import { createContext, Dispatch, useContext, useReducer } from "react";

export type Todo = {
    id: number;
    text: string;
    done: boolean;
};

type TodosState = Todo[];

const TodosStateContext = createContext<TodosState | undefined>(undefined);

type Action =
| {type: "CREATE"; text: string}
| {type: "TOGGLE"; id: number}
| {type: "REMOVE"; id: number};

type TodosDispatch = Dispatch<Action>;

const TodosDispatchContext = createContext<TodosDispatch | undefined>(undefined);

function todosReduder(state: TodosState, action: Action): TodosState{
    switch(action.type) {
        case "CREATE":
            const nextId = Math.max(...state.map((todo) => todo.id)) + 1;
            return state.concat({
                id: nextId,
                text: action.text,
                done: false,
            });
        case "TOGGLE":
            return state.map((todo) => 
                todo.id === action.id ? {...todo, done: !todo.done} : todo
            );
        case "REMOVE":
            return state.filter((todo) => todo.id !== action.id);
        default:
            throw new Error("에러");
    }
}

export function TodosContextProvider({
    children,
}: {
    children: React.ReactNode;
}) {
    const [todos, dispatch] = useReducer(todosReduder, [
        {
            id: 1,
            text: "test",
            done: true,
        },
        {
            id: 2,
            text: "React",
            done: false,
        },
    ]);

    return (
        <TodosDispatchContext.Provider value={dispatch}>
            <TodosStateContext.Provider value={todos}>
                {children}
            </TodosStateContext.Provider>
        </TodosDispatchContext.Provider>
    )
}

export function useTodosState() {
    const state = useContext(TodosStateContext);
    if (!state) throw new Error("TodosProvider not found");
    return state;
}

export function useTodosDispatch() {
    const dispatch = useContext(TodosDispatchContext);
    if (!dispatch) throw new Error("TodosProvider not found");
    return dispatch;
}

