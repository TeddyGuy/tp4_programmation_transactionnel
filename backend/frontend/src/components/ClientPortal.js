import axios from "axios";

import { useEffect, useState } from "react";
import { Col, Row, Spinner } from "react-bootstrap";
import ClientCardList from "./ClientCardList";
import ClientForm from "./ClientForm";

const ClientPortal  = () => {
    const initialFormData = {
        id:'',
        firstName:'',
        lastName:'',
        email:'',
    }

    const [clients, setClients] = useState([]);
    const [formData, setFormData] = useState(initialFormData);  

    useEffect(() => {
        const getClients = async () => {
            const clientsFromServer = await fetchClients();
            setClients(clientsFromServer);
        }
        getClients();
    },[formData]);

    const fetchClients = async () => {
        var clientsFromServer;
        await axios.get("http://localhost:8080/clients").then((response) => {
            clientsFromServer = response.data
        }); 
        return clientsFromServer;
    }

    const formHandler = (e) => {
        e.preventDefault()
        if(formData.id === ''){
            createClient(formData);
        }
        else{
            updateClient();
        }
    }

    const createClient = async (formData) => {
        await axios.post("http://localhost:8080/clients",formData);
        setFormData(initialFormData);
    }

    const updateClient = async () => {
        await axios.patch("http://localhost:8080/clients/" + formData.id,formData);
        setFormData(initialFormData); 
    }

    return(
        <Row className="my-5 mx-5">
            <Col>
                { 
                    clients.length > 0 ?
                    <ClientCardList clients={clients} setFormData={setFormData}/> :
                    <Spinner className='m-auto' animation="border" variant="warning" />
                }       
            </Col>
            <Col>
                <ClientForm 
                formHandler={formHandler}
                formData={formData}
                setFormData={setFormData} />
            </Col>
        </Row>
    );
}

export default ClientPortal;