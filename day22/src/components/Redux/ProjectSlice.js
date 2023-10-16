// projectSlice.js
import { createSlice } from '@reduxjs/toolkit';
import { GetProject } from '../services/Api';

export const projectSlice = createSlice({
    name: 'project',
    initialState: {
        projects: [],
    },
    reducers: {
        addProject: (state, action) => {
            const newProject = action.payload;
            // Check if the project with the same projectId already exists
            const existingProjectIndex = state.projects.findIndex(
                (project) => project.projectId === newProject.projectId
            );
            if (existingProjectIndex === -1) {
                // If it doesn't exist, add it to the array
                state.projects.push(newProject);
            } else {
                // If it exists, update the project in the array
                state.projects[existingProjectIndex] = newProject;
            }
        },
        clearProjects: (state) => {
            state.projects = [];
        },
    },
});

export const fetchProjects = () => async (dispatch) => {
    try {
        const response = await GetProject();
        console.log('API Response:', response);
        console.log('API Response:', response.status);
        if (response.status === 200) {
            console.log('Fetched Projects:', response.data);
            dispatch(addProject(response.data)); // Assuming response.data contains an array of projects
        }
    } catch (error) {
        console.error('Error fetching projects:', error);
    }
};

export const { addProject, clearProjects } = projectSlice.actions;

export default projectSlice.reducer;
