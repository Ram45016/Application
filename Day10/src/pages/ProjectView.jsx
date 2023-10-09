import React, { useEffect, useState } from 'react';
import '../assets/css/ProjectView.css';
import { useNavigate } from 'react-router-dom';
import { GetProject } from '../components/services/Api';

const ProjectView = () => {
    const [showDetails, setShowDetails] = useState(false);
    const [project, setProject] = useState({});
    const navigate = useNavigate();

    useEffect(() => {
        const fetchAllData = async () => {
            try {
                const response = await GetProject();
                console.log(response.data);
                setProject(response.data);
                console.log(project.title);
            } catch (error) {
                console.error('Error fetching project:', error);
            }
        };
        fetchAllData();
    }, []);

    return (
        <div className="project-view">
            <table>
                <thead>
                    <tr>
                        <th>Project Title</th>
                        <th>Details</th>
                        <th>Environment</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>{project.title || 'No Title Provided'}</td>
                        <td>
                            <button onClick={() => setShowDetails(!showDetails)}>
                                {showDetails ? 'Less Info' : 'More Info'}
                            </button>
                        </td>
                        <td>
                            <button onClick={() => navigate(`/environment/${project.projectId}`)}>
                                Open Environment
                            </button>
                        </td>
                    </tr>
                    {showDetails && project.title && ( // Check if project.title exists before rendering details
                        <tr>
                            <td colSpan="3">
                                <div className="project-details">
                                    <div className="project-column">
                                        <p><strong>Description:</strong> {project.description || 'No Description Provided'}</p>
                                        <p><strong>Type:</strong> {project.type || 'Type Not Specified'}</p>
                                        <p><strong>Privacy:</strong> {project.privacy || 'Privacy Not Specified'}</p>
                                    </div>
                                    <div className="project-column">
                                        <h3>Team Members</h3>
                                        <ul>
                                            {(project.teamMembers || []).map(member => (
                                                <li key={member}>{member}</li>
                                            ))}
                                        </ul>
                                    </div>
                                    <div className="project-column">
                                        <h3>Project Goals</h3>
                                        <ul>
                                            {(project.goals || []).map(goal => (
                                                <li key={goal}>{goal}</li>
                                            ))}
                                        </ul>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    );
};

export default ProjectView;
