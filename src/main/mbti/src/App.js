import './App.css';
import { Routes, Route, useNavigate } from 'react-router-dom';
import Result from './pages/Result';
import Admin from './pages/Admin';
import React, {useState} from 'react'; 
import axios from 'axios';

function App() {

  let [input,setinput] = useState(''); //사용자가 입력한 mbti 저장
  let [output,setoutput] = useState('');
  let navigater = useNavigate();
  return (
<>
    <div className="App">
            <header>MBTI</header>
    <Routes>
        <Route path='/' element={ 
          
              <div className='container'>
              <div id="mbti_btns">
                <button className="btn" id="E">E</button>
                <button className="btn" id="S">S</button>
                <button className="btn" id="F">F</button>
                <button className="btn" id="P">P</button>
                <button className="btn" id="I">I</button>
                <button className="btn" id="N">N</button>
                <button className="btn" id="T">T</button>
                <button className="btn" id="J">J</button>
            </div>
            <input onChange={ (e)=>{setinput(e.target.value); console.log(input)}}/><br/>
            <button id="confirm" onClick={ ()=>{ 
              axios.get(`http://localhost:8080/mbti/${input}`)
              .then( (data)=> {
                console.log(data.data.info);
                setoutput(data.data.info);
               })
               .catch( ()=>{
                console.log('실패함');
               })
              navigater('./result');
            }}>확인</button>

        </div>
         } /> 
        <Route path='/result' element={ <Result input={input} output={output}/>} />
        <Route path='/admin' element={ <Admin/> } />
        <Route path='*' element={ <div>없는페이지요</div>} /> 

      </Routes>

      </div>
    
    <footer>
    </footer>
    </>
    
  );
}

export default App;
