import axios from "axios";
const authHeader=localStorage.getItem('token')

const url="http://localhost:8181"

const headers = {
    'Authorization': `Bearer ${authHeader}`,
    'Content-Type':'application/json'
}

//authentication


export const Authlogin=(data)=> axios.post(`${url}/api/v1/auth/authenticate`,data);
export const Authregister=(data)=> axios.post(`${url}/api/v1/auth/register`,data);

//Project
export const CreateProject=(data)=>axios.post(`${url}/api/v1/auth/project/save`,data,headers);
const GetProject=()=>axios.get(`${url}/api/v1/auth/project/all`,headers);

//using path variable
const GetProjectById=(id)=>axios.get(`${url}/api/v1/auth/project/getById/${id}`,headers);

//using requestparam
const GetProjectByIdr=(id)=>axios.get(`${url}/api/v1/auth/project/getById/id=${id}`,headers);

const UpdateProject=(id,data)=>axios.put(`${url}/api/v1/auth/project/update/${id}`,data,headers);

const DelteProject=(id)=>axios.put(`${url}/api/v1/auth/project/delete/${id}`,headers);

