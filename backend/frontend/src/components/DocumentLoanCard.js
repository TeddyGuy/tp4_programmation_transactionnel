import { Card, Button } from "react-bootstrap";
import axios from "axios";
import { useEffect, useState } from "react";
import DocumentCard from "./DocumentCard";

const DocumentLoanCard = ({documentLoan, returnDocument}) => {
    const [document, setDocument] = useState(null);
    
    useEffect(() => {
        const getDocument = async () => {
            const documentFromServer = await fetchDocument();
            setDocument(documentFromServer);
        }
        getDocument();
    },[]);

    const handleReturn = () => {
        returnDocument(documentLoan);
    }

    const fetchDocument = async () => {
        var documentFromServer
        await axios.get("http://localhost:8080/documents/" + documentLoan.documentId).then((response) => {
            documentFromServer = response.data;
          }
        );
        return documentFromServer;
    }

    

    return(
        <>
            <Card className="m-auto mb-1 bg-dark rounded border border-danger" style={{ width: '21rem' }}>
                <Card.Body>
                    {
                        document == null || <DocumentCard document={document}/>
                    }
                    <div className="text-white">
                        Date d'emprunt: { documentLoan.lendingDate } <br/>
                        Date de retour expecté: { documentLoan.expectedReturnDate } <br/>
                        {
                            documentLoan.actualReturnDate == null ?
                            <Button className="mt-1" onClick={handleReturn}>Retourner</Button>:
                            <span>Date de retour: {documentLoan.actualReturnDate}</span>
                        }
                    </div>
                    
                </Card.Body>
            </Card>
        </>
    );
}

export default DocumentLoanCard;