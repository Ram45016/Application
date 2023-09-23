import React, { useState } from 'react';
import ProjectCreate from './ProjectCreate';
import ProjectView from './ProjectView';
import noProjectsImage from '../../assets/images/noProject.png'; 
import '../../assets/css/Project.css';

function Project() {
    const [projects, setProjects] = useState([]);
    const [showCreateForm, setShowCreateForm] = useState(false);

    const handleProjectCreate = (project) => {
        setProjects([...projects, project]);
        setShowCreateForm(false);
    };

    return (
        <div>
            <button onClick={() => setShowCreateForm(true)} className="create-project-btn">
                Create Project
            </button>
            {showCreateForm && 
                <ProjectCreate 
                    onProjectCreate={handleProjectCreate}
                    onClose={() => setShowCreateForm(false)}
                />
            }
            {!showCreateForm && 
                projects.map((project, index) => (
                    <ProjectView key={index} project={project} />
                ))
            }
            {projects.length === 0 && !showCreateForm &&
               <div className="no-projects">
                   <img src={noProjectsImage} alt="No projects" />
                   <p>No projects have been assigned</p>
               </div>
            }
        </div>
    );
}

export default Project;
