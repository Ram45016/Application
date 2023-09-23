import React from 'react';
import { UserProvider, useUser } from './components/context/UserContext';
import AppRoutes from './components/Routing';


function App() {
  return (
      <UserProvider>
        <AppRoutes/>
      </UserProvider>
  );
}

export default App;

