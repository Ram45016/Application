// ProtectedRoutes.js
import React from 'react';
import { Route, Routes } from 'react-router-dom';
import { useUser } from '../context/UserContext';
import Header from '../Header';
import BarChart from '../Dashboard/DashMain';
import Project from '../pages/Project';
import ProjectCreate from '../pages/ProjectCreate';
import ProjectView from '../pages/ProjectView';
import ProjectEnvironment from '../pages/ProjectEnvironment';
import DrawingCanvas from '../Drawing';
import MusicComposing from '../MusicComposing';
import WritingPad from '../WrittingPad';
import AssetsPage from '../AssetsPage';
import YourWorks from '../YourWorks';
import UploadPage from '../UploadPage';
import FollowersPage from '../FollowersPage';
import Home from '../Home';
import Footer from '../Footer';
import ArtistProfile from '../Profile';

const ProtectedRoutes = () => {
  const { isUserLoggedin } = useUser();

  if (!isUserLoggedin) {
    return null; // Return null if user is not logged in
  }

  return (
    <Routes>
      <Route path="/header" element={<Header />} />
      <Route path="/BarChart" element={<BarChart />} />
      <Route path="/project" element={<Project />} />
      <Route path="/projectC" element={<ProjectCreate />} />
      <Route path="/projectV" element={<ProjectView />} />
      <Route path="/environment/:projectId" element={<ProjectEnvironment />} />
      <Route path="/Drawing" element={<DrawingCanvas />} />
      <Route path="/Music" element={<MusicComposing />} />
      <Route path="/write" element={<WritingPad />} />
      <Route path="/assets" element={<AssetsPage />} />
      <Route path="/your-works" element={<YourWorks />} />
      <Route path="/Homepage" element={<Home />} />
      <Route path="/uploadpage" element={<UploadPage />} />
      <Route path="/followers" element={<FollowersPage />} />
      <Route path="/footer" element={<Footer />} />
      <Route path="/profile" element={<ArtistProfile />} />
    </Routes>
  );
};

export default ProtectedRoutes;
