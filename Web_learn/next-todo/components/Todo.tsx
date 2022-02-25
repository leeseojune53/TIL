import styled from "@emotion/styled";
import { TodoType } from "../pages";
import {
  AiFillCheckCircle,
  AiOutlineCheckCircle,
  AiOutlineDelete,
} from "react-icons/ai";
import { useEffect, useState } from "react";

const FlexBox = styled.div`
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  display: flex;
`;

const Container = styled(FlexBox)`
  justify-content: center;
`;

const Box = styled(FlexBox)`
  border: 1px solid #000000;
  border-radius: 10px;
  width: 300px;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 10px;
`;

const FrontBox = styled(FlexBox)`
  display: flex;
  align-items: center;
  padding-left: 10px;
`;

const Textbox = styled.div`
  font-size: 24px;
  padding: 15px;
  text-align: center;
`;

const Button = styled(FlexBox)`
  padding-left: 15px;
  padding-right: 10px;
`;

interface ViewProps {
  todo: TodoType;
  onCheck: (id: number) => void;
  onDelete: (id: number) => void;
}
export default function Todo({ todo, onCheck, onDelete }: ViewProps) {
  const getButton = (value: boolean) => {
    if (value) {
      return <AiFillCheckCircle />;
    } else {
      return <AiOutlineCheckCircle />;
    }
  };

  const onClick = () => {
    onCheck(todo.id);
  };

  return (
    <Container>
      <Box>
        <FrontBox>
          <div
            onClick={() => {
              onClick();
            }}
          >
            {getButton(todo.checked)}
          </div>
          <Textbox>{todo.value}</Textbox>
        </FrontBox>
        <Button>
          <AiOutlineDelete
            onClick={() => {
              onDelete(todo.id);
            }}
          />
        </Button>
      </Box>
    </Container>
  );
}
