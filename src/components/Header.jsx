import React, { useState } from 'react';
import Hamburger from 'hamburger-react';
import { useSelector } from 'react-redux';
import '../assets/css/Header.css';
import { useNavigate } from 'react-router-dom';
import { BsFillPersonFill } from 'react-icons/bs';

const Header = () => {
  const nav = useNavigate();
  const [isOpen, setOpen] = useState(false);
  const [showDropdown, setShowDropdown] = useState(false);
  const username = useSelector(state => state.user?.user?.username);

  const handleLogout = () => {
    setShowDropdown(false);
    nav('/');
  };

  return (
    <header className="headerStyles">
      <div className="hamburgerWrapper" onClick={() => setOpen(!isOpen)}>
        <Hamburger toggled={isOpen} toggle={setOpen} />
      </div>
      <h1 className="headingStyles">ARTNEST</h1>
      <div className="userContainerStyles" onClick={() => setShowDropdown(!showDropdown)}>
        <BsFillPersonFill className='icon' />
        {username}
        {showDropdown && (
          <div className="userDropdown">
            <button onClick={handleLogout}>Logout</button>
          </div>
        )}
      </div>
      {isOpen && (
        <div className={`sidebar ${isOpen ? 'open' : ''}`}>
          <button onClick={() => {/* Some logic */ }}>Exhibit</button>
          <button onClick={() => {/* Some logic */ }}>Display</button>
          <button onClick={() => {/* Some logic */ }}>Collaboration</button>
        </div>
      )}
    </header>
  );
};

export default Header;
  