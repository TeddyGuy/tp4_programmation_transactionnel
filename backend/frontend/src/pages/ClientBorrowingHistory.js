import { useParams } from "react-router-dom";
import { Col, Row } from "react-bootstrap";
import { useEffect, useState } from "react";
import axios from "axios";
import DocumentLoanCardList from "../components/DocumentLoansCardList";
import useForceUpdate from "../hooks/useForceUpdate";


const ClientBorrowingHistory = () => {
    const {id} = useParams();
    const[client, setClient] = useState({});
    const[documentLoans, setDocumentLoans] = useState([]);
    const [update, forceUpdate] = useForceUpdate();

    const fetchClient = async () => {
        var clientFromServer;
        await axios.get("http://localhost:8080/clients/" + id).then((response) => {
            clientFromServer = response.data
        }); 
        return clientFromServer;
    }
    const fetchDocumentLoans = async () => {
        var documentLoansFromServer;
        await axios.get("http://localhost:8080/clients/" + id + "/borrowing-history").then((response) => {
            documentLoansFromServer = response.data
        }); 
        return documentLoansFromServer;
    }

    const returnDocument = async (documentLoan) => {
        await axios.post("http://localhost:8080/document-loans/" + documentLoan.id + "/return");
        forceUpdate();
    }

    useEffect(() => {
        const getClient = async () => {
            const clientFromServer = await fetchClient();
            setClient(clientFromServer);
        }
        const getDocuments = async () => {
            const documentLoansFromServer = await fetchDocumentLoans();
            setDocumentLoans(documentLoansFromServer);
        }
        getDocuments();
        getClient();
    },[update])

    

    return(
        <>
            <h1 className="text-center">Historique d'emprunt de {client.firstName}, {client.lastName}</h1>
            <Row className="py-5 px-5">
                <Col>
                    <DocumentLoanCardList documentLoans={documentLoans} returnDocument={returnDocument}/>
                </Col>
                <Col>
                </Col>
            </Row>
        </>
    );
}

export default ClientBorrowingHistory;