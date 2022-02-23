import styled from "@emotion/styled";

const Container = styled.div`
  display: flex;
  justify-content: center;
`;

const FlexBox = styled.div`
  display: flex;
`;

const Box = styled(FlexBox)`
  align-items: center;
  border: 1px solid #000000;
  border-radius: 10px;
  width: 300px;
`;

const Textbox = styled.div`
  font-size: 24px;
  padding: 15px;
  text-align: center;
`;

interface ViewProps {
  todo: string;
}
export default function Todo({ todo }: ViewProps) {
  return (
    <Container>
      <Box>
        <input type="checkbox" />
        <Textbox>{todo}</Textbox>
      </Box>
    </Container>
  );
}
