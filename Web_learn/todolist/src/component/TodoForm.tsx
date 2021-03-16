import { useState } from "react";
import { useTodosDispatch } from "../context/TodosContext";

function TodoForm() {
    const [value, setValue] = useState("");
    const dispatch = useTodosDispatch();

    const onSubmit = (e: React.FormEvent) => {

        if(value == "")
            throw new Error("Empty");

        e.preventDefault();

        dispatch({
            type: "CREATE",
            text: value,
        });
        setValue("");
    };
    
    return (
        <form onSubmit={onSubmit}>
            <input 
            value={value}
            placeholder="적어"
            onChange={(e) => setValue(e.target.value)}
            />
            <button>등록</button>
        </form>
    )

}

export default TodoForm;