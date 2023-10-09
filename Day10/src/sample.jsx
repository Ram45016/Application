import React, { useState, useEffect } from 'react';
import '../assets/css/ProjectView.css';
import { useNavigate } from 'react-router-dom';
import { GetProject } from '../components/services/Api';

const ProjectView = () => {
    const [projects, setProjects] = useState([]);
    const navigate = useNavigate();

    // Fetch all project data from the backend when the component mounts
    useEffect(() => {
        // Define a function to fetch all project data
        const fetchAllProjects = async () => {
            try {
                const response = await GetProject(); // Call GetAllProjects to fetch all projects
                setProjects(response.data); // Assuming the data is an array of project objects
            } catch (error) {
                console.error('Error fetching project data:', error);
            }
        };

        // Call the fetchAllProjects function
        fetchAllProjects();
    }, []);

    return (
        <div className="project-view">
            <table>
                <thead>
                    <tr>
                        <th>Project Title</th>
                        <th>Description</th>
                        <th>Type</th>
                        <th>Privacy</th>
                        <th>Team Members</th>
                        <th>Project Goals</th>
                        <th>Environment</th>
                    </tr>
                </thead>
                <tbody>
                    {projects.map(project => (
                        <tr key={project.projectId}>
                            <td>{project.title || 'No Title Provided'}</td>
                            <td>{project.description || 'No Description Provided'}</td>
                            <td>{project.type || 'Type Not Specified'}</td>
                            <td>{project.privacy || 'Privacy Not Specified'}</td>
                            <td>
                                {project.teamMembers && project.teamMembers.length > 0 ? (
                                <ul>
                                    {project.teamMembers.map(member => (
                                        <li key={member}>{member}</li>
                                     ))}
                                </ul>
                                     ) : (
                                        <p>No team members assigned</p>
                                        )}
                            </td>
                            <td>
                                <ul>
                                    {(project.goals || []).map(goal => (
                                        <li key={goal}>{goal}</li>
                                    ))}
                                </ul>
                            </td>
                            <td>
                                <button onClick={() => navigate(`/environment/${project.projectId}`)}>
                                    Open Environment
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default ProjectView;
