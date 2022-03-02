import styled from "@emotion/styled";
import { useState } from "react";

const Container = styled.div`
  display: flex;
  justify-content: center;
  padding: 10px 0px 50px;
`;

const InputBox = styled.div`
  padding-right: 10px;
`;

interface InputProps {
  addValue: (value: string) => void;
}
export default function Input({ addValue }: InputProps) {
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

  const onKeyPress = (e) => {
    if (e.key === "Enter") {
      onChange();
    }
  };

  return (
    <Container>
      <InputBox>
        <input
          type="text"
          value={text}
          onKeyPress={onKeyPress}
          onChange={textChangeHandler}
        />
      </InputBox>
      <button onClick={onChange}>submit</button>
    </Container>
  );
}
