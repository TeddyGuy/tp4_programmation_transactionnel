import axios from "axios";
import { useEffect, useState } from "react";
import { Col, Row } from "react-bootstrap";
import ClientCardList from "./ClientCardList";

const ClientPortal  = () => {
    const [clients, setClients] = useState([]);

    useEffect(() => {
        const getClients = async () => {
            const clientsFromServer = await fetchClients();
            setClients(clientsFromServer);
        }
        getClients();
    },[]);

    const fetchClients = async () => {
        var clientsFromServer;
        await axios.get("http://localhost:8080/clients").then((response) => {
            clientsFromServer = response.data
        }); 
        return clientsFromServer;
    }

    return(
        <Row className="my-5 mx-5">
            <Col>
                { 
                    clients.length > 0 ?
                    <ClientCardList clients={clients}/> :
                    'No Clients...'
                }
               
            </Col>
            <Col></Col>
        </Row>
    );
}

export default ClientPortal;