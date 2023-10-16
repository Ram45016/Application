import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchProjects } from '../Redux/ProjectSlice';

function ProjectList() {
    const dispatch = useDispatch();
    const projects = useSelector((state) => state.project.projects);
    console.log(projects);
    
    useEffect(() => {
        // Dispatch the action to fetch projects when the component mounts
        dispatch(fetchProjects());
    }, [dispatch]);
    return (
        <div>
            {projects && projects.map((project) => (
                <div key={project.projectId}>{project.projectId}</div>
            ))}
        </div>
    );
}

export default ProjectList;
