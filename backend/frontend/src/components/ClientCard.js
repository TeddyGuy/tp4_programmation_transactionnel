import { Card, Button } from "react-bootstrap";



const ClientCard = ({client, setFormData}) => {

    const sendClientInfoToForm = () => {
        const formData = {
            id:client.id,
            firstName:client.firstName,
            lastName:client.lastName,
            email:client.email
        }
        setFormData(formData)
    }

    return(
        <>
            <Card className="m-auto mb-1" style={{ width: '18rem' }}>
                <Card.Body>
                    <Card.Title>
                        { client.email }
                    </Card.Title>
                    <Card.Text>
                        {client.firstName}, { client.lastName }
                    </Card.Text>
                    <Button variant="warning" onClick={sendClientInfoToForm}>Modifier</Button> <Button variant="primary">Emprunts</Button>
                </Card.Body>
            </Card>
        </>
    );
}

export default ClientCard;