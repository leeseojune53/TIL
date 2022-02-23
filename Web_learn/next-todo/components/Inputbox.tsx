import styled from "@emotion/styled";
import { useState } from "react";

const Container = styled.div`
  display: flex;
  justify-content: center;
  padding: 10px 0px 50px;
`;

interface InputBoxProps {
  addValue: (value: string) => void;
}
export default function InputBox({ addValue }: InputBoxProps) {
  const [text, setText] = useState("");

  const textChangeHandler = (e: any) => {
    setText(e.currentTarget.value);
  };

  const onChange = () => {
    if ((text.length as number) == 0) alert("값을 입력해주세요.");
    else {
      addValue(text);
      setText("");
    }
  };

  return (
    <Container>
      <input type="text" value={text} onChange={textChangeHandler} />
      <button onClick={onChange}>submit</button>
    </Container>
  );
}
