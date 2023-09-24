import React from 'react';
import '../assets/css/SideBar.css'

const Sidebar = ({ isOpen }) => {
  return (
    <div className={`sidebar ${isOpen ? 'open' : ''}`}>
      <button onClick={() => {/* Some logic */ }}>Exhibit</button>
      <button onClick={() => {/* Some logic */ }}>Display</button>
      <button onClick={() => {/* Some logic */ }}>Collaboration</button>
    </div>
  );
};

export default Sidebar;
