import styled from 'styled-components';

const Wrapper = styled.div`
  width: 100%;
  height: 100%;
  border: 1px solid red;
  & .todolist-container {
    margin-top: 20px;
    padding: 20px;
  }
  & .title-container {
    padding: 10px;
    border-radius: 30px;
    margin-bottom: 10px;
  }
  & .title-subcontainer {
    justify-content: center;
  }
  & .content-container {
    padding: 20px;
    border-radius: 30px;
  }
  & .title-input {
    background-color: transparent;
    border: none;
    color: #000000;
    width: 80%;
    height: 100%;
    font-size: 20px;
    :focus {
      outline: none;
    }
  }
  & .content-input {
    background-color: transparent;
    border: none;
    color: #000000;
    width: 100%;
    height: 100%;
    font-size: 18px;
    :focus {
      outline: none;
    }
  }
  & .content-input-complete {
    background-color: transparent;
    border: none;
    color: #cecece;
    width: 100%;
    height: 100%;
    font-size: 18px;
    :focus {
      outline: none;
    }
  }
  & .input-container {
    text-align: center;
  }
`;

export default Wrapper;