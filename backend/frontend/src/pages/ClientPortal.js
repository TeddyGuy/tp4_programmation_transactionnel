import axios from "axios";
import { useEffect, useState } from "react";
import { Col, Row, Spinner } from "react-bootstrap";
import ClientCardList from "../components/ClientCardList";
import ClientForm from "../components/ClientForm";
import useForceUpdate from "../hooks/useForceUpdate";

const ClientPortal  = () => {
    const initialFormData = {
        id:'',
        firstName:'',
        lastName:'',
        email:'',
    }

    const [clients, setClients] = useState([]);
    const [formData, setFormData] = useState(initialFormData); 
    const [update,forceUpdate] = useForceUpdate();

    useEffect(() => {
        const getClients = async () => {
            const clientsFromServer = await fetchClients();
            setClients(clientsFromServer);
        }
        getClients();
    },[formData, update]);

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
            createClient();
        }
        else{
            updateClient();
        }
    }

    const createClient = async () => {
        await axios.post("http://localhost:8080/clients",formData);
        setFormData(initialFormData);
    }

    const updateClient = async () => {
        await axios.patch("http://localhost:8080/clients/" + formData.id,formData);
        forceUpdate();
    }

    const onDelete = async (client) => {
        await axios.delete("http://localhost:8080/clients/" + client.id);
        forceUpdate();
    }

    return(
        <Row className="py-5 px-5 m-0">
            <Col>
                { 
                    clients.length > 0 ?
                    <ClientCardList clients={clients} setFormData={setFormData} onDelete={onDelete}/> :
                    <Spinner className='m-auto' animation="border" variant="warning"/>
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