import { Card, Button } from "react-bootstrap";
import { useEffect, useState } from "react";
import DocumentCard from "./DocumentCard";
import { fetchDocument } from "../hooks/apiHooks";

const DocumentLoanCard = ({documentLoan, returnDocument}) => {
    const [document, setDocument] = useState(null);
    
    useEffect(() => {
        const getDocument = async () => {
            const documentFromServer = await fetchDocument(documentLoan.documentId);
            setDocument(documentFromServer);
        }
        getDocument();
    },[]);

    const handleReturn = () => {
        returnDocument(documentLoan);
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