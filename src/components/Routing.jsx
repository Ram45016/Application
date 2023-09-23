import React from 'react';
import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import LoginAndSignUp from './LoginAndSignUp';
import Header from './Header';
import BarChart from './Dashboard/DashMain';
import { useUser } from './context/UserContext';
import Project from './pages/Project';
import ProjectCreate from './pages/ProjectCreate';
import ProjectView from './pages/ProjectView';
import ProjectEnvironment from './pages/ProjectEnvironment';
import DrawingCanvas from './Drawing';

const PrivateRoute=({children})=>{
    const {isUserLoggedin}=useUser();
    return isUserLoggedin ? children : <Navigate to="/" replace/>;
  }
  


const AppRoutes = () => {
  return (
        <BrowserRouter>
            <Routes>
                <Route exact path="/" element={<LoginAndSignUp/>} />
                <Route path="/header" element={
                    <PrivateRoute>
                     <Header/>
                    </PrivateRoute>
                } />
               <Route path="/BarChart" element={<BarChart/>} />
               <Route path="/project" element={<Project/>} />
               <Route path="/projectC" element={<ProjectCreate/>} />
               <Route path="/projectV" element={<ProjectView/>} />
               <Route path="/environment" element={<ProjectEnvironment/>} />
               <Route path="/Drawing" element={<DrawingCanvas/>} />
            </Routes>
        </BrowserRouter>
  );
};

export default AppRoutes;
