import logo from './logo.svg';
import './App.css';
import MyNavbar from './components/MyNavbar';
import { Route, Routes } from 'react-router-dom';
import ClientPortal from './components/ClientPortal';
import AdminPortal from './components/AdminPortal';

const App = () => {
    return( 
    <>
       <MyNavbar/>
       <Routes>
           <Route path='/client-portal' element={<ClientPortal/>}/>
           <Route path='/admin-portal' element={<AdminPortal/>}/>
       </Routes>
    </>
    )
}

export default App;
