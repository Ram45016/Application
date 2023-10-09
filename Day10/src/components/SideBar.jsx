import React from 'react';
import { FaImages, FaBriefcase, FaUsers, FaUserFriends, FaUpload, FaHome } from 'react-icons/fa'; 
import '../assets/css/SideBar.css';
import { useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';

const Sidebar = ({ isOpen,closeSidebar }) => {
    const username = useSelector(state => state.user?.user?.username) || "Guest";
    const navigate = useNavigate();  
    const handleNavigation = (path) => {
        closeSidebar();
        navigate(path);
    };
    return (
        <div className={`sidebar ${isOpen ? 'open' : ''}`}>
            <div className="username-display">
                Welcome, {username}!
            </div>
            <button className="sidebar-button" onClick={() => handleNavigation('/Homepage')}>
                <FaHome className="option-icon" />
                Home
            </button>
            <button className="sidebar-button" onClick={() => handleNavigation('/assets')}>
                <FaImages className="option-icon" />
                Exhibit
            </button>
            <button className="sidebar-button" onClick={() => handleNavigation('/your-works')}>
                <FaBriefcase className="option-icon" />
                Display
            </button>
            <button className="sidebar-button" onClick={() => handleNavigation('/project')}>
                <FaUsers className="option-icon" />
                Collaboration
            </button>
            <button className="sidebar-button" onClick={() => handleNavigation('/uploadpage')}>
                <FaUpload className="option-icon" />
                Upload
            </button>
            <button className="sidebar-button" onClick={() => handleNavigation('/followers')}>
                <FaUserFriends className="option-icon" />
                Followers
            </button>
            {username === "Admin" && (
                <>
                    <button className="sidebar-button" onClick={() => handleNavigation('/admin/projects')}>
                        <FaUsers className="option-icon" />
                        Projects
                    </button>
                    <button className="sidebar-button" onClick={() => handleNavigation('/admin/users')}>
                        <FaUserFriends className="option-icon" />
                        Users
                    </button>
                </>
            )}
        </div>
    );
};

export default Sidebar;
