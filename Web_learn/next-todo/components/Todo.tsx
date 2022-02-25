import styled from "@emotion/styled";
import { TodoType } from "../pages";

const FlexBox = styled.div`
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
`;

const FrontBox = styled(FlexBox)`
  display: flex;
  align-items: center;
`;

const Textbox = styled.div`
  font-size: 24px;
  padding: 15px;
  text-align: center;
`;

const Button = styled(FlexBox)`
  padding-left: 15px;
`;

interface ViewProps {
  todo: TodoType;
  onCheck: (id: number) => void;
  onDelete: (id: number) => void;
}
export default function Todo({ todo, onCheck, onDelete }: ViewProps) {
  return (
    <Container>
      <Box>
        <FrontBox>
          <input
            type="checkbox"
            onClick={() => {
              onCheck(todo.id);
            }}
          />
          <Textbox>{todo.value}</Textbox>
        </FrontBox>
        <Button>
          <button
            onClick={() => {
              onDelete(todo.id);
            }}
          >
            X🗑️
          </button>
        </Button>
      </Box>
    </Container>
  );
}
