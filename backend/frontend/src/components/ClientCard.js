import { Card, Button } from "react-bootstrap";
import CloseButton from 'react-bootstrap/CloseButton'



const ClientCard = ({client, setFormData, onDelete}) => {

    const sendClientInfoToForm = () => {
        const formData = {
            id:client.id,
            firstName:client.firstName,
            lastName:client.lastName,
            email:client.email
        }
        setFormData(formData)
    }

    const deleteClient = () => {
        onDelete(client);
    }

    return(
        <>
            <Card className="m-auto mb-1" style={{ width: '19rem' }}>
                <Card.Body>
                    <Card.Title>
                        { client.email }
                    </Card.Title>
                    <Card.Text>
                        {client.firstName}, { client.lastName }
                    </Card.Text>
                    <Button variant="warning me-1" onClick={sendClientInfoToForm}>Modifier</Button> 
                    <Button className="me-5" variant="primary">Emprunts</Button>
                    <CloseButton onClick={deleteClient}/>
                </Card.Body>
            </Card>
        </>
    );
}

export default ClientCard;