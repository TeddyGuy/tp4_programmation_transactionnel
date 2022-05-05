import { Navbar,Nav,Container} from 'react-bootstrap';
const { Link } = require("react-router-dom")


const MyNavbar = () => {
    return(
       <nav>
           <Navbar bg="dark" variant="dark" expand="md">
                <Container>
                    <Navbar.Brand href="#home">Bibliothèque Javatown</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link as={Link} to="/client-portal">Portail Client</Nav.Link>
                            <Nav.Link as={Link} to="/admin-portal">Portail Admin</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
       </nav>
    )
}

export default MyNavbar;