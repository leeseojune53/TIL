import {useForm} from 'react-hook-form';

const Signup = () => {
  const { register, handleSubmit } = useForm();

  const onSubmit = (data: any) => {
    console.log(data);
  };
  
  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <input type="text" name="name" ref={register} />
      <div></div>
      <input type="password" name="password" ref={register}/>
      <div></div>
      <input type="submit" />
    </form>
  );
};

export default Signup;