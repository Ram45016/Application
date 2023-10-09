import React, { useState } from 'react';
import '../../assets/css/ProjectView.css';
import { useNavigate } from 'react-router-dom';

const ProjectView = ({ project = {} }) => {
    const [showDetails, setShowDetails] = useState(false);
    const navigate = useNavigate();

    return (
        <div className="project-view">
            <table>
                <thead>
                    <tr>
                        {/* Removed Project ID header */}
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
                                {showDetails ? "Less Info" : "More Info"}
                            </button>
                        </td>
                        <td>
                            <button onClick={() => navigate(`/environment/${project.projectId}`) }>
                                Open Environment
                            </button>
                        </td>
                    </tr>
                    {showDetails && (
                        <tr>
                            <td colSpan="3"> {/* Updated colSpan to 3 since there's one less column now */}
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
