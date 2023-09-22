import * as React from 'react'
import { useState } from 'react'
import { Link } from 'react-router-dom';
import '../assets/css/loginAndSignUp.css'

const LoginAndSignUp=()=>{
    const [isFlipped, setIsFlipped] = useState(false);

    const flipForm = () => {
        setIsFlipped(!isFlipped);
    };

    const[loginFormData,setLoginFormData]=React.useState({
        username:"",
        password:""
    })
    const[signUpFormData,setSignUpFormData]=React.useState({
        email:"",
        username:"",
        password:""
    })

    
    const handleLoginFormChange=(e)=>{
        const [name,value]=[e.target.name,e.target.value];
        setLoginFormData({
            ...loginFormData,
            [name]: value
        })
    }
    
    const handleSignUpFormChange=(e)=>{
        const [name,value]=[e.target.name,e.target.value];
        setSignUpFormData({
            ...signUpFormData,
            [name]: value
        })
    }

    const submitLoginForm = (e) => {
        e.preventDefault();
        console.log(loginFormData);
    }

    const submitSignUpForm = (e) => {
       e.preventDefault();
        console.log(signUpFormData);
    }
    
    return(
        <div className='loginAndSignUpPage'>
            <div className={`forms-container ${isFlipped ? 'flipped' : ''}`}>
                <div className='form-box login'>
                    <h1>Login</h1>
                    <form onSubmit={submitLoginForm} className='loginForm'>
                        <div className='username'>
                            <input type="email" name="username" id="username" placeholder='username' onChange={handleLoginFormChange}/>
                        </div>
                        <div className='password'>
                            <input type="password" name="password" id="password" placeholder="password" onChange={handleLoginFormChange}/>
                        </div>
                        <div className='loginButton'>
                            <button type="submit">Login</button>
                        </div> 
                        <Link to="#" onClick={flipForm}>If you didn't have an account</Link>                   
                    </form>
                </div>
            <div className='form-box signup'>
                <h1>SignUp</h1>
                <form onSubmit={submitSignUpForm} className='signUpForm'>
                    <div className='email'>
                        <input type='email' name='email' id='email' placeholder='email' onChange={handleSignUpFormChange}></input>
                    </div>
                    <div className='username'>
                        
                        <input type="text" name="username" id="username" placeholder='username' onChange={handleSignUpFormChange}/>
                    </div>
                    <div className='password'>
                        <input type="password" name="password" id="password" placeholder="password" onChange={handleSignUpFormChange}/>
                    </div>
                    <div className='signUpButton'>
                        <button type="submit">SignUp</button>
                    </div>
                    <Link to="#" onClick={flipForm}>If you have an account</Link>
                </form>
            </div>
            </div>
        </div>
    )
}
export default LoginAndSignUp;