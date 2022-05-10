import logo from './logo.svg';
import './App.css';
import MyNavbar from './components/MyNavbar';
import { Route, Routes } from 'react-router-dom';
import ClientPortal from './pages/ClientPortal';
import AdminPortal from './pages/AdminPortal';
import ClientBorrowingHistory from './pages/ClientBorrowingHistory';

const App = () => {
    return( 
    <>
       <MyNavbar/>
       <Routes>
           <Route path='/client-portal' element={<ClientPortal/>}/>
           <Route path='/admin-portal' element={<AdminPortal/>}/>
           <Route path='/client/:id/borrowing-history' element={<ClientBorrowingHistory/>}/>
       </Routes>
    </>
    )
}

export default App;
