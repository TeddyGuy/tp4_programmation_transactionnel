import { Card, Button } from "react-bootstrap";



const ClientCard = ({client}) => {

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
                    <Button variant="warning">Détails</Button>
                </Card.Body>
            </Card>
        </>
    );
}

export default ClientCard;