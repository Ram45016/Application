import React, { useEffect, useState } from 'react';
import ProjectCreate from './ProjectCreate';
import ProjectView from './ProjectView';
import { useSelector, useDispatch } from 'react-redux';
import { clearProjects, fetchProjects } from '../Redux/ProjectSlice'; // Adjust the path based on your directory structure
import noProjectsImage from '../../assets/images/noProject.png'; 
import '../../assets/css/Project.css';

function Project() {
    const dispatch = useDispatch();
    
    useEffect(() => {
        // Dispatch the action to fetch projects when the component mounts
        dispatch(fetchProjects());
    }, [dispatch]);
    
    const projectsFromRedux = useSelector(state => state.project.projects);
    console.log('Projects in Redux:', projectsFromRedux);

    const [showCreateForm, setShowCreateForm] = useState(false);

    const handleCreateFormOpen = () => {
        setShowCreateForm(true);
    };

    const handleCreateFormClose = () => {
        setShowCreateForm(false);
    };

    const handleClearProjects = () => {
        dispatch(clearProjects());
    };

    return (
        <div className='project-comp'>
            <button onClick={handleCreateFormOpen} className="create-project-btn">
                Create Project
            </button>
            {showCreateForm && 
                <ProjectCreate onClose={handleCreateFormClose} />
            }
            
            {!showCreateForm && projectsFromRedux.length > 0 && (
                <div className="project-list">
                        <ProjectView />
                </div>
            )}
            {projectsFromRedux.length === 0 && !showCreateForm &&
               <div className="no-projects">
                   <img src={noProjectsImage} alt="No projects" />
                   <p>No projects have been assigned</p>
               </div>
            }
              {projectsFromRedux.length > 0 && 
                <button onClick={handleClearProjects} className="clear-projects-btn">
                    Clear All Projects
                </button>
            }
        </div>
    );
}

export default Project;
