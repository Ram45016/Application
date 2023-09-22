import React from 'react';
import { useNavigate } from 'react-router';
import '../../assets/css/Details.css';
import Header from '../Header';
import Footer from '../Footer';


const Detail = () => {

  const nav = useNavigate();

  return (
    <div>
    <div className='detail-body'>
        <Header></Header>
      <main class="detail-main-container">
        <div class="detail-main-title">
         
         </div>

        <div class="detail-main-cards">

          <div class="card">
            <div class="card-inner">
              <h2>TOTAL VIEWS  :  537</h2>
            </div>
              
            
          </div>

          <div class="card">
            <div class="card-inner">
              <h1>NEW ARTIST : 217</h1>
             
            </div>
          </div>

          <div class="card">
            <div class="card-inner">
              <h1>DOWNLOADS : 320</h1>
             
            </div>
           
          </div>

          <div class="card">
            <div class="card-inner">
              <h1>COLLABORATION PROJECT : 25</h1>
            
            </div>
           
          </div>

        </div>

        
      </main>
    </div>
      <Footer></Footer>
      </div>
  );
};

export default Detail;
