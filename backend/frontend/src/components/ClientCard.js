import { Button } from "react-bootstrap";
import { Card } from "react-bootstrap";


const ClientCard = ({client}) => {

    return(
        <>
            <Card className="m-auto" style={{ width: '18rem' }}>
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