import logo from './logo.svg';
import './App.css';
import MyNavbar from './components/MyNavbar';
import { Route, Routes } from 'react-router-dom';
import ClientPortal from './components/ClientPortal';

const App = () => {
    return( 
    <>
       <MyNavbar/>
       <Routes>
           <Route path='/client-portal' element={<ClientPortal/>}/>
       </Routes>
    </>
    )
}

export default App;
